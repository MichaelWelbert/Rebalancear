package com.example.app.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.core.request.RequestState
import com.example.app.domain.usecases.DeleteAssetUseCase
import com.example.app.domain.usecases.GetAssetUseCase

import com.example.app.domain.usecases.GetOwnedPercentUseCase
import com.example.app.domain.usecases.GetPatrimonyUseCase
import com.example.app.domain.usecases.GetUnitsGoalUseCase
import com.example.app.presentation.adapter.PresenterAdapter
import com.example.app.presentation.events.AssetEvent
import com.example.app.presentation.presenter.AssetPresenter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
internal class AssetViewModel @Inject constructor(
    private val deleteAssetUseCase: DeleteAssetUseCase,
    private val getAssetUseCase: GetAssetUseCase,
    private val getPatrimonyUseCase: GetPatrimonyUseCase,
    private val presenterAdapter: PresenterAdapter,
    private val getUnitsGoalUseCase: GetUnitsGoalUseCase,
    private val getOwnedPercentUseCase: GetOwnedPercentUseCase
) : ViewModel() {

    private var _patrimony by mutableStateOf(0f)


    private var _asset by mutableStateOf(AssetPresenter())
    val asset get() = _asset


    fun onEvent(event: AssetEvent) {
        when (event) {
            AssetEvent.OnDeleteAsset -> deleteAsset()
            is AssetEvent.OnEditAsset -> {}
            is AssetEvent.OnLoadAsset -> {
                runBlocking {
                    getPatrimony()
                    getAsset(event.code)
                }

            }
        }
    }


    private fun deleteAsset() {
        deleteAssetUseCase(_asset.code).onEach { result ->
            when (result) {
                is RequestState.Error -> Log.d("michael", "mandar snack error DeleteAsset")
                is RequestState.Success -> Log.d("michael", "mandar snack Sucesso DeleteAsset")
            }
        }.launchIn(viewModelScope)
    }


    private fun getAsset(code: String) {
        getAssetUseCase(code).onEach { result ->
            when (result) {
                is RequestState.Error -> Log.d("michael", "error  getAsset")
                is RequestState.Success -> {
                    val data = result.data ?: return@onEach
                    val ownedPercent = getOwnedPercentUseCase(_patrimony, data.units, data.unitPrice)
                    val unitsGoal = getUnitsGoalUseCase(_patrimony, data.unitPrice, data.goal, ownedPercent)
                    _asset = presenterAdapter.buildAsset(data, ownedPercent, unitsGoal)
                    Log.d("michael", asset.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getPatrimony() {
        getPatrimonyUseCase().onEach { result ->
            when (result) {
                is RequestState.Error -> Log.d("michael", "error  getPatrimony")
                is RequestState.Success -> {
                    val data = result.data ?: return@onEach
                    _patrimony = data
                }
            }
        }.launchIn(viewModelScope)
    }
}
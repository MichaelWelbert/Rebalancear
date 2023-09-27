package com.example.app.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.core.request.RequestState
import com.example.app.domain.usecases.AddAssetUseCase
import com.example.app.domain.usecases.GetOwnedPercentUseCase
import com.example.app.domain.usecases.GetPatrimonyByAssetsUseCase
import com.example.app.domain.usecases.GetUnitsGoalUseCase
import com.example.app.domain.usecases.GetWalletUseCase
import com.example.app.presentation.adapter.PresenterAdapter
import com.example.app.presentation.events.WalletEvent
import com.example.app.presentation.presenter.AssetPresenter
import com.example.app.presentation.states.AddAssetState
import com.example.rebalancear.presentation.events.WalletAssetPageEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WalletViewModel @Inject constructor(
    private val addAssetUseCase: AddAssetUseCase,
    private val getWalletUseCase: GetWalletUseCase,
    private val getPatrimonyByAssetsUseCase: GetPatrimonyByAssetsUseCase,
    private val getUnitsGoalUseCase: GetUnitsGoalUseCase,
    private val getOwnedPercentUseCase: GetOwnedPercentUseCase,
    private val presenterAdapter: PresenterAdapter
) : ViewModel() {

    private var _wallet by mutableStateOf<List<AssetPresenter>>(emptyList())
    val wallet get() = _wallet


    private var _addAssetDialogState by mutableStateOf<AddAssetState>(AddAssetState.Hide)
    val addAssetDialogState get() = _addAssetDialogState


    private val _walletAssetPageEvent = MutableSharedFlow<WalletAssetPageEvent>()
    val alletAssetPageEvent = _walletAssetPageEvent.asSharedFlow()


    fun onEvent(event :WalletEvent) {
        when(event) {
            is WalletEvent.OnAddWalletAsset -> {
                addAsset(event.code, event.units, event.goal)
            }
            is WalletEvent.OnChangeAddAssetState -> {
                changeAddAssetDialogState(event.state)
            }

            WalletEvent.OnLoadWallet -> getWallet()
        }
    }

    private fun changeAddAssetDialogState(addAssetState: AddAssetState) {

        _addAssetDialogState = addAssetState
    }
    private fun addAsset(code: String, units: Float, goal: Float) {
        addAssetUseCase(code, units, goal).onEach { result ->
            if (result is RequestState.Error) {
                Log.d("michael", result.error.message)
            }
        }.launchIn(viewModelScope)
    }




    private fun getWallet() {
        getWalletUseCase().onEach { result ->
            when (result) {
                is RequestState.Error -> Log.d("michael", "error  getWallet")
                is RequestState.Success -> {
                    val assets = result.data ?: return@onEach
                    val patrimony = getPatrimonyByAssetsUseCase(assets)
                    _wallet = assets.map { asset ->
                        val ownedPercent = getOwnedPercentUseCase(patrimony,  asset.units,  asset.unitPrice)
                        val unitsGoal = getUnitsGoalUseCase(patrimony,  asset.unitPrice,  asset.goal, ownedPercent)
                        presenterAdapter.buildAsset(asset, ownedPercent, unitsGoal)
                    }

                    Log.d("michael", wallet.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}


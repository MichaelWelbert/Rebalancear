package com.example.rebalancear.presentation.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.core.request.ErrorMessage
import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.domain.entities.WalletAsset
import com.example.rebalancear.domain.usecases.*
import com.example.rebalancear.presentation.events.AssetScreenEvents
import com.example.rebalancear.presentation.events.AssetNavigationEvent
import com.example.rebalancear.presentation.presenters.AssetPresenter
import com.example.rebalancear.presentation.states.AssetState
import com.example.rebalancear.presentation.states.base.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
internal class AssetViewModel @Inject constructor(
    val deleteWalletAssetUseCase: DeleteWalletAssetUseCase,
    val getContributeStateUseCase: GetContributeStateUseCase,
    val getInvestedAmountUseCase: GetInvestedAmountUseCase,
    val getWalletAssetsUseCase: GetWalletAssetsUseCase,
    val getInvestedAmountGoalUseCase: GetInvestedAmountGoalUseCase,
    val getOwnedUseCase: GetPercentageOwnedUseCase,
    val calculatePatrimonyUseCase: CalculatePatrimonyUseCase,
    val getUnitGoalUseCase: GetUnitGoalUseCase,
    val updateWalletAssetUseCase: UpdateWalletAssetUseCase,
    val getGrahamFairPriceUseCase: GetGrahamFairPriceUseCase
) : ViewModel() {


    private var _assetState by mutableStateOf(AssetState())
    val assetState get() = _assetState

    private val _navigationEvent = MutableSharedFlow<AssetNavigationEvent>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    fun onTriggerEvent(event: AssetScreenEvents) {
        when (event) {
            is AssetScreenEvents.OnDeleteAsset -> deleteAsset(event.code)
            is AssetScreenEvents.OnUpdateWalletAsset -> updateWalletAsset(
                event.code,
                event.units,
                event.goal
            )
        }
    }

    fun loadWalletAssets(code: String?) {
        if (code == null || code == "") {
            _assetState = AssetState(state = RequestState.Error(ErrorMessage.CannotFindData()))
        } else {
            getWalletAssetsUseCase().onEach { result ->
                when (result) {
                    is ResultRequest.Error -> {
                        _assetState = AssetState(state = RequestState.Error(result.errorMessage))
                    }
                    is ResultRequest.Loading -> {
                        _assetState = AssetState(state = RequestState.Loading())
                    }
                    is ResultRequest.Success -> {
                        val assets = result.data
                        val asset = assets.find { it.code == code }
                        _assetState = if (asset == null) {
                            AssetState(state = RequestState.Error(ErrorMessage.CannotFindData()))
                        } else {
                            val patrimony = calculatePatrimonyUseCase(assets)
                            val assetPresenter = getAssetPresenter(asset, patrimony)
                            AssetState(state = RequestState.Success(assetPresenter))
                        }
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    private fun updateWalletAsset(code: String, units: Double, goal: Double) {
        updateWalletAssetUseCase(code, units, goal).onEach { result ->
            when (result) {
                is ResultRequest.Error -> {
                }
                is ResultRequest.Loading -> {
                }
                is ResultRequest.Success -> {

                }
            }
        }.launchIn(viewModelScope)
    }


    private fun deleteAsset(code: String) {

        deleteWalletAssetUseCase(code).onEach { result ->
            when (result) {
                is ResultRequest.Error -> {

                }
                is ResultRequest.Loading -> {

                }
                is ResultRequest.Success -> {
                    _navigationEvent.emit(AssetNavigationEvent.OnAssetNavigationBack)
                }
            }
        }.launchIn(viewModelScope)
    }


    private fun getAssetPresenter(asset: WalletAsset, patrimony: Double): AssetPresenter {

        val investedAmount = getInvestedAmountUseCase(
            units = asset.units,
            unitsPrice = asset.unitPrice
        )
        val percentOwned = getOwnedUseCase(
            patrimony = patrimony,
            investedAmount = investedAmount
        )
        val contributeState = getContributeStateUseCase(
            percentOwned = percentOwned,
            percentGoal = asset.percentGoal
        )

        val investedAmountGoal = getInvestedAmountGoalUseCase(
            patrimony = patrimony,
            percentGoal = asset.percentGoal,
            percentOwned = percentOwned
        )

        val unitsGoal = getUnitGoalUseCase(
            price = asset.unitPrice,
            investedAmountGoal = investedAmountGoal,
            assetType = asset.type
        )

        val grahamFairPrice = getGrahamFairPriceUseCase(
            LPA = asset.LPA,
            VPA = asset.VPA
        )

        return AssetPresenter(
            code = asset.code,
            units = asset.units,
            unitPrice = asset.unitPrice,
            percentGoal = asset.percentGoal,
            percentOwned = percentOwned,
            investedAmount = investedAmount,
            investedAmountGoal = investedAmountGoal,
            contributeState = contributeState,
            unitsGoal = unitsGoal,
            grahamFairPrice = grahamFairPrice
        )
    }
}



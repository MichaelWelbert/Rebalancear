package com.example.rebalancear.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.domain.entities.WalletAsset
import com.example.rebalancear.domain.usecases.*
import com.example.rebalancear.presentation.events.WalletAssetScreenEvents
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.presentation.presenters.WalletPresenter
import com.example.rebalancear.presentation.states.PageState
import com.example.rebalancear.presentation.states.WalletState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
internal class WalletViewModel @Inject constructor(
    private val getWalletAssetsUseCase: GetWalletAssetsUseCase,
    private val getContributeStateUseCase: GetContributeStateUseCase,
    private val getInvestedAmountUseCase: GetInvestedAmountUseCase,
    private val getPercentageOwnedUseCase: GetPercentageOwnedUseCase,
    private val calculatePatrimonyUseCase: CalculatePatrimonyUseCase,
    private val addWalletAssetUseCase: AddWalletAssetUseCase,
) : ViewModel() {


    private var _walletState by mutableStateOf(WalletState())
    val walletState get() = _walletState


    init {
        loadWalletAssets()
    }

    fun onTriggerEvent(event: WalletAssetScreenEvents) {
        when (event) {
            is WalletAssetScreenEvents.OnAddWalletAsset -> {
                addWalletAsset(event.code, event.units, event.goal)
            }

        }
    }

    private fun loadWalletAssets() {
        getWalletAssetsUseCase().onEach { result ->
            _walletState = when (result) {
                is ResultRequest.Error -> {
                    WalletState(state = PageState.Error(result.resultError))
                }
                is ResultRequest.Loading -> {
                    WalletState(state = PageState.Loading())
                }
                is ResultRequest.Success -> {
                    val patrimony = calculatePatrimonyUseCase(result.data)
                    val assets = getWalletAssetPresenter(result.data, patrimony)
                    val walletPresenter = WalletPresenter(assets = assets, patrimony = patrimony)
                    WalletState(state = PageState.Success(walletPresenter))
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun addWalletAsset(code: String, units: Double, goal: Double) {

        addWalletAssetUseCase(code, units,  goal).onEach { result ->
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


    private fun getWalletAssetPresenter(
        walletAsset: List<WalletAsset>,
        patrimony: Double
    ): List<WalletAssetPresenter> {
        return walletAsset.map { asset ->
            val investedAmount = getInvestedAmountUseCase(
                units = asset.units,
                unitsPrice = asset.unitPrice
            )
            val percentOwned = getPercentageOwnedUseCase(
                patrimony = patrimony,
                investedAmount = investedAmount
            )
            val contributeState = getContributeStateUseCase(
                percentOwned = percentOwned,
                percentGoal = asset.percentGoal
            )

            WalletAssetPresenter(
                code = asset.code,
                units = asset.units,
                unitPrice = asset.unitPrice,
                percentGoal = asset.percentGoal,
                percentOwned = percentOwned,
                investedAmount = investedAmount,
                contributeState = contributeState,
            )
        }
    }
}
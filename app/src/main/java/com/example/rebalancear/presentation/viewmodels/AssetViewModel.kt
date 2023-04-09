package com.example.rebalancear.presentation.viewmodels


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rebalancear.core.ResultError
import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.domain.entities.WalletAsset
import com.example.rebalancear.domain.usecases.*
import com.example.rebalancear.presentation.presenters.AssetPresenter
import com.example.rebalancear.presentation.states.AssetState
import com.example.rebalancear.presentation.states.PageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
internal class AssetViewModel @Inject constructor(
    val getContributeStateUseCase: GetContributeStateUseCase,
    val getInvestedAmountUseCase: GetInvestedAmountUseCase,
    val getWalletAssetsUseCase: GetWalletAssetsUseCase,
    val getInvestedAmountGoalUseCase: GetInvestedAmountGoalUseCase,
    val getPercentageOwnedUseCase: GetPercentageOwnedUseCase,
    val calculatePatrimonyUseCase: CalculatePatrimonyUseCase,
    val getUnitGoalUseCase: GetUnitGoalUseCase,
) : ViewModel() {


    private var _assetState by mutableStateOf(AssetState())
    val assetState get() = _assetState


    fun loadWalletAssets(code: String?) {
        if (code == null || code == "") {
            _assetState = AssetState(state = PageState.Error(ResultError.CannotFindData()))
        } else {
            getWalletAssetsUseCase().onEach { result ->
                when (result) {
                    is ResultRequest.Error -> {
                        _assetState = AssetState(state = PageState.Error(result.resultError))
                    }
                    is ResultRequest.Loading -> {
                        _assetState = AssetState(state = PageState.Loading())
                    }
                    is ResultRequest.Success -> {
                        val assets = result.data
                        val asset = assets.find { it.code == code }
                        _assetState = if (asset == null) {
                            AssetState(state = PageState.Error(ResultError.CannotFindData()))
                        } else {
                            val patrimony = calculatePatrimonyUseCase(assets)
                            val assetPresenter = getAssetPresenter(asset, patrimony)
                            AssetState(state = PageState.Success(assetPresenter))
                        }
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    private fun getAssetPresenter(asset: WalletAsset, patrimony: Double): AssetPresenter {

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

        return AssetPresenter(
            code = asset.code,
            units = asset.units,
            unitPrice = asset.unitPrice,
            percentGoal = asset.percentGoal,
            percentOwned = percentOwned,
            investedAmount = investedAmount,
            investedAmountGoal = investedAmountGoal,
            contributeState = contributeState,
            unitsGoal = unitsGoal
        )
    }
}


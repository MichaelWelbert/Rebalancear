package com.example.rebalancear.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import com.example.rebalancear.core.AssetTypes
import com.example.rebalancear.core.ContributeState
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.presentation.states.WalletState

class WalletViewModel : ViewModel() {


    private var _walletAssets by mutableStateOf(WalletState())
    val walletState: WalletState get() = _walletAssets

    init {
        val assets = listOf(
            WalletAssetPresenter(
                code = "BBAS3",
                assetType = AssetTypes.STOCKS,
                investedAmount = 25000f,
                percentageGoal = 5f,
                percentageOwned = 2f,
                contributeState = ContributeState.CONTRIBUTE
            ),
            WalletAssetPresenter(
                code = "HGRU11",
                assetType = AssetTypes.FIIS,
                investedAmount = 2000f,
                percentageGoal = 3f,
                percentageOwned = 4f,
                contributeState = ContributeState.WAIT
            ),
            WalletAssetPresenter(
                code = "CDB 100%",
                assetType = AssetTypes.BONDS,
                investedAmount = 12000f,
                percentageGoal = 5f,
                percentageOwned = 5f,
                contributeState = ContributeState.WAIT
            ),
            WalletAssetPresenter(
                code = "BITCOIN",
                assetType = AssetTypes.CRYPTO,
                investedAmount = 3211200f,
                percentageGoal = 6f,
                percentageOwned = 3f,
                contributeState = ContributeState.CONTRIBUTE
            ),
            WalletAssetPresenter(
                code = "BBAS31",
                assetType = AssetTypes.STOCKS,
                investedAmount = 25000f,
                percentageGoal = 5f,
                percentageOwned = 2f,
                contributeState = ContributeState.CONTRIBUTE
            ),
            WalletAssetPresenter(
                code = "HGRU111",
                assetType = AssetTypes.FIIS,
                investedAmount = 2000f,
                percentageGoal = 3f,
                percentageOwned = 4f,
                contributeState = ContributeState.WAIT
            ),
            WalletAssetPresenter(
                code = "CDB 1001%",
                assetType = AssetTypes.BONDS,
                investedAmount = 12000f,
                percentageGoal = 5f,
                percentageOwned = 5f,
                contributeState = ContributeState.WAIT
            ),
            WalletAssetPresenter(
                code = "BITCOIN1",
                assetType = AssetTypes.CRYPTO,
                investedAmount = 3211200f,
                percentageGoal = 6f,
                percentageOwned = 3f,
                contributeState = ContributeState.CONTRIBUTE
            ),
            WalletAssetPresenter(
                code = "BBAS32",
                assetType = AssetTypes.STOCKS,
                investedAmount = 25000f,
                percentageGoal = 5f,
                percentageOwned = 2f,
                contributeState = ContributeState.CONTRIBUTE
            ),
            WalletAssetPresenter(
                code = "HGRU113",
                assetType = AssetTypes.FIIS,
                investedAmount = 2000f,
                percentageGoal = 3f,
                percentageOwned = 4f,
                contributeState = ContributeState.WAIT
            ),
            WalletAssetPresenter(
                code = "CDB 1002%",
                assetType = AssetTypes.BONDS,
                investedAmount = 12000f,
                percentageGoal = 5f,
                percentageOwned = 5f,
                contributeState = ContributeState.WAIT
            ),
            WalletAssetPresenter(
                code = "BITCOIN2",
                assetType = AssetTypes.CRYPTO,
                investedAmount = 3211200f,
                percentageGoal = 6f,
                percentageOwned = 3f,
                contributeState = ContributeState.CONTRIBUTE
            )
        )
        _walletAssets = WalletState(assets = assets)
    }

    fun getPatrimony(): Float {
        if (_walletAssets.assets.isEmpty())
            return 0f

        val assetsInvestedAmount = _walletAssets.assets.map { assets -> assets.investedAmount }
        return assetsInvestedAmount.reduce { acc, assetAmount -> acc + assetAmount }
    }
}
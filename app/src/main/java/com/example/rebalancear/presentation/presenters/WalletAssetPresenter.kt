package com.example.rebalancear.presentation.presenters
import com.example.rebalancear.core.AssetTypes
import com.example.rebalancear.core.ContributeState

data class WalletAssetPresenter(
    var code: String,
    var assetType: AssetTypes,
    var investedAmount: Float,
    var percentageOwned: Float,
    var percentageGoal: Float,
    var contributeState: ContributeState
)
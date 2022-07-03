package com.example.rebalancear.domain.models

data class WalletAssetModel(
    var code: String,
    var investedAmount: Float,
    var percentageGoal: Float,
)
package com.example.rebalancear.domain.entities

import com.example.rebalancear.core.AssetType

data class WalletAsset(
    val code: String = "",
    val type: AssetType = AssetType.NATIONAL_STOCKS,
    val units:  Double = 0.0,
    val unitPrice:  Double = 0.0,
    val percentGoal: Double = 0.0,
)
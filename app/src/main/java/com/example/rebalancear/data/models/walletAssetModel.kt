package com.example.rebalancear.data.models

import com.example.rebalancear.core.AssetType

data class WalletAssetPriceModel (
    val code: String = "",
    val unitPrice:  Double = 0.0,
    val type: AssetType = AssetType.NATIONAL_STOCKS,
)
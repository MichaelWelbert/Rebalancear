package com.example.rebalancear.presentation.events

sealed class AssetScreenEvents {
    data class OnDeleteAsset(val code: String) : AssetScreenEvents()
    data class OnUpdateWalletAsset(val code: String, val units: Double, val goal: Double) :
        AssetScreenEvents()
}
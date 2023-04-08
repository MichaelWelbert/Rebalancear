package com.example.rebalancear.presentation.events

sealed class WalletAssetScreenEvents {
    data class OnAddWalletAsset(val code: String, val units: Double) : WalletAssetScreenEvents()
}
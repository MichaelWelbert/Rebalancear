package com.example.rebalancear.presentation.events

sealed class WalletAssetScreenEvents {
    data class OnAddWalletAsset(val code: String, val units: Double, val goal:Double) : WalletAssetScreenEvents()
    data class OnClickAsset(val code: String) : WalletAssetScreenEvents()
    object RefreshPage : WalletAssetScreenEvents()
    object ResetPage : WalletAssetScreenEvents()
}
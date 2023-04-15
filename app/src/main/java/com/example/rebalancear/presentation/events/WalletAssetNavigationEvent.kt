package com.example.rebalancear.presentation.events

sealed class WalletAssetNavigationEvent {
    data class OnNavigationAsset(val code: String): WalletAssetNavigationEvent()
}
package com.example.app.presentation.events

import com.example.app.presentation.states.AddAssetState

sealed class WalletEvent {
    data class OnAddWalletAsset(val code: String, val units: Float, val goal:Float) : WalletEvent()
    data class OnChangeAddAssetState (val state: AddAssetState) : WalletEvent()
    object OnLoadWallet : WalletEvent()
}
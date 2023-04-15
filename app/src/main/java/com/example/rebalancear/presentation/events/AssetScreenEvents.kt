package com.example.rebalancear.presentation.events

sealed class AssetScreenEvents {
    data class OnDeleteAsset(val code: String) : AssetScreenEvents()
}
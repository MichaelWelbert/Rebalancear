package com.example.app.presentation.events

sealed class AssetEvent {
    data class OnEditAsset(val units: Float, val goal:Float) : AssetEvent()
    data class OnLoadAsset(val code:String) : AssetEvent()

    object OnDeleteAsset : AssetEvent()
}
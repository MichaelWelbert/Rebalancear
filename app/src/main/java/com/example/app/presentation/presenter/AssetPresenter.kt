package com.example.app.presentation.presenter

data class AssetPresenter(
    val code: String = "",
    val unitPrice: Float = 0f,
    val unitsGoal: Float = 0f,
    val units: Float = 0f,
    val goal: Float = 0f,
    val owned: Float = 0f
)
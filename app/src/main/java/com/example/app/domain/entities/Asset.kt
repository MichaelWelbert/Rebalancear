package com.example.app.domain.entities

data class Asset (
    val code: String = "",
    val unitPrice: Float = 0f,
    val units: Float = 0f,
    val goal: Float = 0f,
)
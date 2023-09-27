package com.example.app.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WalletAssetRoomEntity(
    val unitPrice: Float,
    val units: Float,
    val goal : Float,
    @PrimaryKey
    val code: String,
)
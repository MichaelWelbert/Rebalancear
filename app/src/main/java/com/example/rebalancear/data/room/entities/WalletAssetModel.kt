package com.example.rebalancear.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WalletAssetModel(
    val units: Double,
    val goal: Double,
    @PrimaryKey
    val code: String,
)
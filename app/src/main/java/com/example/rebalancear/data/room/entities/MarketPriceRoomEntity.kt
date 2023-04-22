package com.example.rebalancear.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MarketPriceRoomEntity(
    val price: Double,
    @PrimaryKey
    val code: String,
)
package com.example.rebalancear.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MarketInfoRoomEntity(
    val price: Double,
    val LPA: Double,
    val VPA: Double,
    @PrimaryKey
    val code: String,
)
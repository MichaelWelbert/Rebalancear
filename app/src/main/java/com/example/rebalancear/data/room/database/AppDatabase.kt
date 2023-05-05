package com.example.rebalancear.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rebalancear.data.room.dao.AssetDataDao
import com.example.rebalancear.data.room.entities.MarketInfoRoomEntity
import com.example.rebalancear.data.room.entities.WalletAssetRoomEntity


@Database(
    entities = [WalletAssetRoomEntity::class, MarketInfoRoomEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun assetDataDao(): AssetDataDao
}



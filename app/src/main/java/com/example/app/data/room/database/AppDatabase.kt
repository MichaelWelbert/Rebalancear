package com.example.app.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.app.data.room.dao.AssetDataDao
import com.example.app.data.room.entities.WalletAssetRoomEntity


@Database(
    entities = [WalletAssetRoomEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun assetDataDao(): AssetDataDao
}



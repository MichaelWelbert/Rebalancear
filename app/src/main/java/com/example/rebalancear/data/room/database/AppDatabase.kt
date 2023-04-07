package com.example.rebalancear.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rebalancear.data.room.dao.WalletAssetDao
import com.example.rebalancear.data.room.entities.WalletAssetModel


@Database(
    entities = [WalletAssetModel::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun walletAssetDao(): WalletAssetDao
}



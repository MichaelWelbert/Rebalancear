package com.example.rebalancear.data.room.dao

import androidx.room.*
import com.example.rebalancear.data.room.entities.WalletAssetModel

@Dao
interface WalletAssetDao {
    @Query("SELECT * FROM WalletAssetModel")
    suspend fun getAll(): List<WalletAssetModel>

    @Delete
    suspend fun deleteAll(vararg wallet: WalletAssetModel)

    @Query("SELECT * FROM WalletAssetModel WHERE code LIKE :code")
    suspend fun findByCode(code: String): WalletAssetModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg wallet: WalletAssetModel)

    @Delete
    suspend fun delete(wallet: WalletAssetModel)


}

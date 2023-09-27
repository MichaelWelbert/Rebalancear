package com.example.app.data.room.dao

import androidx.room.*
import com.example.app.data.room.entities.WalletAssetRoomEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AssetDataDao {
    @Query("SELECT * FROM WalletAssetRoomEntity")
    fun getWalletAssetAll(): Flow<List<WalletAssetRoomEntity>>

    @Delete
    suspend fun deleteWalletAssetAll(vararg wallet: WalletAssetRoomEntity)

    @Query("SELECT * FROM WalletAssetRoomEntity WHERE code LIKE :code")
    suspend fun findWalletAssetByCode(code: String): WalletAssetRoomEntity?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertWalletAssetAll(vararg wallet: WalletAssetRoomEntity)

    @Delete
    suspend fun deleteWalletAsset(wallet: WalletAssetRoomEntity)
}

package com.example.rebalancear.data.room.dao

import androidx.room.*
import com.example.rebalancear.data.room.entities.WalletAssetRoomEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WalletAssetDao {
    @Query("SELECT * FROM WalletAssetRoomEntity")
    fun getAll(): Flow<List<WalletAssetRoomEntity>>

    @Delete
    suspend fun deleteAll(vararg wallet: WalletAssetRoomEntity)

    @Query("SELECT * FROM WalletAssetRoomEntity WHERE code LIKE :code")
    suspend fun findByCode(code: String): WalletAssetRoomEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg wallet: WalletAssetRoomEntity)

    @Delete
    suspend fun delete(wallet: WalletAssetRoomEntity)


}

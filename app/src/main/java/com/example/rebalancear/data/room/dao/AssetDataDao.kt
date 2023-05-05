package com.example.rebalancear.data.room.dao

import androidx.room.*
import com.example.rebalancear.data.room.entities.MarketInfoRoomEntity
import com.example.rebalancear.data.room.entities.WalletAssetRoomEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AssetDataDao {
    @Query("SELECT * FROM WalletAssetRoomEntity")
    fun getWalletAssetAll(): Flow<List<WalletAssetRoomEntity>>

    @Delete
    suspend fun deleteWalletAssetAll(vararg wallet: WalletAssetRoomEntity)

    @Query("SELECT * FROM WalletAssetRoomEntity WHERE code LIKE :code")
    suspend fun findWalletAssetByCode(code: String): WalletAssetRoomEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWalletAssetAll(vararg wallet: WalletAssetRoomEntity)

    @Delete
    suspend fun deleteWalletAsset(wallet: WalletAssetRoomEntity)


    @Query("SELECT * FROM MarketInfoRoomEntity")
    fun getMarketInfoAll(): Flow<List<MarketInfoRoomEntity>>

    @Delete
    suspend fun deleteMarketInfoAll(vararg wallet: MarketInfoRoomEntity)

    @Query("SELECT * FROM MarketInfoRoomEntity WHERE code LIKE :code")
    suspend fun findMarketInfoByCode(code: String): MarketInfoRoomEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarketInfoAll(vararg wallet: MarketInfoRoomEntity)

    @Delete
    suspend fun deleteMarketInfo(wallet: MarketInfoRoomEntity)


}

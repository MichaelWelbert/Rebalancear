package com.example.rebalancear.data.room.dao

import androidx.room.*
import com.example.rebalancear.data.room.entities.MarketPriceRoomEntity
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


    @Query("SELECT * FROM MarketPriceRoomEntity")
    fun getMarketPriceAll(): Flow<List<MarketPriceRoomEntity>>

    @Delete
    suspend fun deleteMarketPriceAll(vararg wallet: MarketPriceRoomEntity)

    @Query("SELECT * FROM MarketPriceRoomEntity WHERE code LIKE :code")
    suspend fun findMarketPriceByCode(code: String): MarketPriceRoomEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarketPriceAll(vararg wallet: MarketPriceRoomEntity)

    @Delete
    suspend fun deleteMarketPrice(wallet: MarketPriceRoomEntity)


}

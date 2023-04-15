package com.example.rebalancear.domain.repository

import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.domain.entities.WalletAsset
import kotlinx.coroutines.flow.Flow

interface IWalletAssetRepository {
    suspend fun getWalletAssets(): Flow<ResultRequest<List<WalletAsset>>>
    suspend fun addWalletAsset(code: String, units: Double, goal: Double)
    suspend fun deleteWalletAsset(code: String)
    suspend fun hasWalletAsset(code: String) : Boolean
    fun removeWalletAsset(code: String)
    fun updateWalletUnitAsset(code: String, unit: Int)
    fun updateWalletGoalAsset(code: String, goal: Float)
}
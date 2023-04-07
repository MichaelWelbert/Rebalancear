package com.example.rebalancear.domain.repository

import com.example.rebalancear.domain.entities.WalletAsset

interface IWalletAssetRepository {
    suspend fun getWalletAssets(): List<WalletAsset>
    fun getWalletAsset(code: String): WalletAsset?
    suspend fun addWalletAsset(code: String, units: Double)
    suspend fun hasWalletAsset(code: String) : Boolean
    fun removeWalletAsset(code: String)
    fun updateWalletUnitAsset(code: String, unit: Int)
    fun updateWalletGoalAsset(code: String, goal: Float)
}
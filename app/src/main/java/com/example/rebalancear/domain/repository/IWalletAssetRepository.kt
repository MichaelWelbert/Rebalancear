package com.example.rebalancear.domain.repository

import com.example.rebalancear.domain.entities.WalletAsset

interface IWalletAssetRepository {
    fun getWalletAssets(): List<WalletAsset>
    fun getWalletAsset(code: String): WalletAsset?
    fun addWalletAsset(asset: WalletAsset)
    fun removeWalletAsset(code: String)
    fun updateWalletUnitAsset(code: String, unit: Int)
    fun updateWalletGoalAsset(code: String, goal: Float)
}
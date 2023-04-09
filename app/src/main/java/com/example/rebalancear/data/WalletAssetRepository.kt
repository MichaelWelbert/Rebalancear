package com.example.rebalancear.data


import com.example.rebalancear.core.AssetType
import com.example.rebalancear.data.adapters.WalletAssetAdapter
import com.example.rebalancear.data.room.dao.WalletAssetDao
import com.example.rebalancear.data.room.entities.WalletAssetModel
import com.example.rebalancear.domain.entities.WalletAsset
import com.example.rebalancear.domain.repository.IWalletAssetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WalletAssetRepository @Inject constructor(
    private val walletAssetDataBase: WalletAssetDao,
    private val walletAssetAdater: WalletAssetAdapter
) : IWalletAssetRepository {


    private var mocklist = mutableListOf(

        WalletAsset(
            code = "BBSE3",
            percentGoal = 12.0,
            units = 57.00,
            unitPrice = 28.48,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAsset(
            code = "ITSA4",
            percentGoal = 12.0,
            units = 177.0,
            unitPrice = 9.32,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAsset(
            code = "SAPR11",
            percentGoal = 12.0,
            units = 81.0,
            unitPrice = 18.50,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAsset(
            code = "AESB3",
            percentGoal = 12.0,
            units = 145.0,
            unitPrice = 10.03,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAsset(
            code = "TAEE11",
            percentGoal = 12.0,
            units = 34.0,
            unitPrice = 41.65,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAsset(
            code = "RANI3",
            percentGoal = 6.67,
            units = 136.0,
            unitPrice = 7.26,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAsset(
            code = "WIZS3",
            percentGoal = 6.67,
            units = 100.0,
            unitPrice = 8.52,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAsset(
            code = "SOJA3",
            percentGoal = 6.67,
            units = 60.0,
            unitPrice = 12.46,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAsset(
            code = "CSAN3",
            percentGoal = 6.67,
            units = 37.0,
            unitPrice = 20.83,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAsset(
            code = "SIMH3",
            percentGoal = 6.67,
            units = 63.0,
            unitPrice = 11.18,
            type = AssetType.NATIONAL_STOCKS
        ),

        WalletAsset(
            code = "HASH11",
            percentGoal = 6.67,
            units = 36.0,
            unitPrice = 20.34,
            type = AssetType.NATIONAL_STOCKS
        ),

        )

    override suspend fun getWalletAssets(): Flow<List<WalletAsset>> = flow {
        walletAssetDataBase.getAll().collect { walletAssetModel ->
            val walletAssets = walletAssetAdater.buildWalletAssets(walletAssetModel).toMutableList()
            emit(walletAssets)
        }
    }

    override fun getWalletAsset(code: String): WalletAsset? {
        val walletAsset = mocklist.firstOrNull { asset ->
            asset.code.uppercase() == code.uppercase()
        }

        return walletAsset
    }

    override suspend fun addWalletAsset(code: String, units: Double, goal: Double) {
        val walletAssetModel = WalletAssetModel(code = code, units = units, goal = goal)
        walletAssetDataBase.insertAll(walletAssetModel)
    }

    override suspend fun hasWalletAsset(code: String): Boolean {
        val walletAsset = walletAssetDataBase.findByCode(code)
        return walletAsset != null
    }

    override fun removeWalletAsset(code: String) {
        TODO("Not yet implemented")
    }

    override fun updateWalletUnitAsset(code: String, unit: Int) {
        TODO("Not yet implemented")
    }

    override fun updateWalletGoalAsset(code: String, goal: Float) {
        TODO("Not yet implemented")
    }

}

fun getDolarPrice(price: Double): Double {
    val dolarPrice = 5.4
    return price * dolarPrice
}
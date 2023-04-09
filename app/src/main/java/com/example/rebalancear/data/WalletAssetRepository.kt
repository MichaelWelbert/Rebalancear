package com.example.rebalancear.data


import android.util.Log
import com.example.rebalancear.core.AssetType
import com.example.rebalancear.core.ResultError
import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.data.adapters.WalletAssetAdapter
import com.example.rebalancear.data.models.WalletAssetPriceModel
import com.example.rebalancear.data.room.dao.WalletAssetDao
import com.example.rebalancear.data.room.entities.WalletAssetRoomEntity
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
        WalletAssetPriceModel(
            code = "BBSE3",
            unitPrice = 28.48,
            type = AssetType.NATIONAL_STOCKS
        ),

        WalletAssetPriceModel(
            code = "ITSA4",

            unitPrice = 9.32,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAssetPriceModel(
            code = "SAPR11",
            unitPrice = 18.50,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAssetPriceModel(
            code = "AESB3",
            unitPrice = 10.03,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAssetPriceModel(
            code = "TAEE11",
            unitPrice = 41.65,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAssetPriceModel(
            code = "RANI3",
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAssetPriceModel(
            code = "WIZS3",
            unitPrice = 8.52,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAssetPriceModel(
            code = "SOJA3",
            unitPrice = 12.46,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAssetPriceModel(
            code = "CSAN3",
            unitPrice = 20.83,
            type = AssetType.NATIONAL_STOCKS
        ),
        WalletAssetPriceModel(
            code = "SIMH3",
            unitPrice = 11.18,
            type = AssetType.NATIONAL_STOCKS
        ),

        WalletAssetPriceModel(
            code = "BBAS3",
            unitPrice = 20.34,
            type = AssetType.NATIONAL_STOCKS
        ),

        )

    override suspend fun getWalletAssets(): Flow<ResultRequest<List<WalletAsset>>> = flow {
        walletAssetDataBase.getAll().collect { userAssetsInfo ->

            val dontHaveCode = userAssetsInfo.any { asset ->
                findAssetPrice(asset.code) == null
            }

            if (dontHaveCode) {
                emit(ResultRequest.Error(ResultError.CannotFindCode()))
                return@collect
            }

            val walletAssets = userAssetsInfo.mapNotNull { userAssetInfo ->
                findAssetPrice(userAssetInfo.code)?.let { assetPriceModel ->
                    walletAssetAdater.buildWalletAssets(userAssetInfo, assetPriceModel)
                }
            }

            emit(ResultRequest.Success(walletAssets))

        }
    }

    private fun findAssetPrice(code: String): WalletAssetPriceModel? {
        return mocklist.find { it.code.equals(code, ignoreCase = true) }
    }

    override suspend fun addWalletAsset(code: String, units: Double, goal: Double) {
        val walletAssetRoomEntity = WalletAssetRoomEntity(code = code, units = units, goal = goal)
        walletAssetDataBase.insertAll(walletAssetRoomEntity)
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
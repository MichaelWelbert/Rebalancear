package com.example.rebalancear.data


import com.example.rebalancear.core.ResultError
import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.data.adapters.WalletAssetAdapter
import com.example.rebalancear.data.models.WalletAssetModel
import com.example.rebalancear.data.room.dao.AssetDataDao
import com.example.rebalancear.data.room.entities.MarketInfoRoomEntity
import com.example.rebalancear.data.room.entities.WalletAssetRoomEntity
import com.example.rebalancear.data.yahoofinance.IMarket
import com.example.rebalancear.domain.entities.WalletAsset
import com.example.rebalancear.domain.repository.IWalletAssetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class WalletAssetRepository @Inject constructor(
    private val assetDataBase: AssetDataDao,
    private val market: IMarket,
    private val walletAssetAdater: WalletAssetAdapter
) : IWalletAssetRepository {

    override suspend fun getWalletAssets(): Flow<ResultRequest<List<WalletAsset>>> = flow {
        emit(ResultRequest.Loading())

        assetDataBase.getWalletAssetAll().collect { userAssetsInfo ->
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

    private suspend fun findAssetPrice(code: String): WalletAssetModel? {
        val dataBaseWallet = assetDataBase.findMarketInfoByCode(code.uppercase())
        val walletAssetPrice = dataBaseWallet?.let { marketAsset ->
            WalletAssetModel(
                code = marketAsset.code,
                unitPrice = marketAsset.price,
                VPA = marketAsset.VPA,
                LPA = marketAsset.LPA
            )
        }

        return walletAssetPrice
    }

    override suspend fun addWalletAsset(
        code: String,
        units: Double,
        goal: Double
    ): Flow<ResultRequest<Unit>> = flow {
        emit(ResultRequest.Loading())
        try {
            val stock = market.getStock(code)

            if (stock == null)
                emit(ResultRequest.Error(ResultError.CannotFindStocks()))
            else {
                val stockPrice = stock.price ?: 0.0
                val stockLPA = stock.LPA ?: 0.0
                val stockVPA = stock.VPA ?: 0.0

                val walletAssetInfoRoomEntity =
                    MarketInfoRoomEntity(
                        code = code.uppercase(),
                        price = stockPrice,
                        LPA = stockLPA,
                        VPA = stockVPA
                    )

                val walletAssetRoomEntity =
                    WalletAssetRoomEntity(
                        code = code.uppercase(Locale.ROOT),
                        units = units,
                        goal = goal
                    )

                assetDataBase.insertWalletAssetAll(walletAssetRoomEntity)
                assetDataBase.insertMarketInfoAll(walletAssetInfoRoomEntity)

                emit(ResultRequest.Success(Unit))
            }
        } catch (e:Exception) {
            emit(ResultRequest.Error(ResultError.CannotFindAsset()))
        }

    }

    override suspend fun updateWalletAsset(
        code: String,
        units: Double,
        goal: Double
    ): Flow<ResultRequest<Unit>> = flow {
        emit(ResultRequest.Loading())
        val currentWalletAsset = assetDataBase.findWalletAssetByCode(code)

        if (currentWalletAsset == null)
            emit(ResultRequest.Error(ResultError.CannotFindStocks()))
        else {
            val walletAssetRoomEntity = currentWalletAsset.copy(units = units, goal = goal)
            assetDataBase.insertWalletAssetAll(walletAssetRoomEntity)
            emit(ResultRequest.Success(Unit))
        }
    }

    override suspend fun deleteWalletAsset(code: String) {

        val walletAsset = assetDataBase.findWalletAssetByCode(code.uppercase(Locale.ROOT))
        walletAsset?.let { assetDataBase.deleteWalletAsset(it) }
    }

    override suspend fun hasWalletAsset(code: String): Boolean {

        val walletAsset = assetDataBase.findWalletAssetByCode(code.uppercase(Locale.ROOT))
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
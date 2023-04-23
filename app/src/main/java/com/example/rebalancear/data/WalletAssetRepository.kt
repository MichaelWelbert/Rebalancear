package com.example.rebalancear.data


import com.example.rebalancear.core.ResultError
import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.data.adapters.WalletAssetAdapter
import com.example.rebalancear.data.models.WalletAssetPriceModel
import com.example.rebalancear.data.room.dao.AssetDataDao
import com.example.rebalancear.data.room.entities.MarketPriceRoomEntity
import com.example.rebalancear.data.room.entities.WalletAssetRoomEntity
import com.example.rebalancear.data.yahoofinance.IMarket
import com.example.rebalancear.data.yahoofinance.Stock
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

    private suspend fun findAssetPrice(code: String): WalletAssetPriceModel? {
        val dataBaseWallet = assetDataBase.findMarketPriceByCode(code.uppercase())
        val walletAssetPrice = dataBaseWallet?.let { marketAsset ->
            WalletAssetPriceModel(
                marketAsset.code,
                marketAsset.price
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
        val stockPriceInDataBase = findAssetPrice(code)
        val stockPrice = stockPriceInDataBase?.unitPrice ?: market.getStockPrice(Stock(code))

        if (stockPrice == null)
            emit(ResultRequest.Error(ResultError.CannotFindStocks()))
        else {
            val walletAssetPriceRoomEntity =
                MarketPriceRoomEntity(code = code.uppercase(), price = stockPrice)

            val walletAssetRoomEntity =
                WalletAssetRoomEntity(
                    code = code.uppercase(Locale.ROOT),
                    units = units,
                    goal = goal
                )

            assetDataBase.insertWalletAssetAll(walletAssetRoomEntity)
            assetDataBase.insertMarketPriceAll(walletAssetPriceRoomEntity)

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
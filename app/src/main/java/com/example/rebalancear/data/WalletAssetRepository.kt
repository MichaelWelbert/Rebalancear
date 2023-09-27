package com.example.rebalancear.data



import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.domain.entities.WalletAsset
import com.example.rebalancear.domain.repository.IWalletAssetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WalletAssetRepository @Inject constructor(
) : IWalletAssetRepository {

    override suspend fun getWalletAssets(): Flow<ResultRequest<List<WalletAsset>>> = flow {
        emit(ResultRequest.Loading())
    }

    /*private suspend fun findAssetPrice(code: String): WalletAssetModel? {
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

     */

    override suspend fun addWalletAsset(
        code: String,
        units: Double,
        goal: Double
    ): Flow<ResultRequest<Unit>> = flow {
        emit(ResultRequest.Loading())
    }

    override suspend fun updateWalletAsset(
        code: String,
        units: Double,
        goal: Double
    ): Flow<ResultRequest<Unit>> = flow {
        emit(ResultRequest.Loading())
      /*  val currentWalletAsset = assetDataBase.findWalletAssetByCode(code)

        if (currentWalletAsset == null)
            emit(ResultRequest.Error(ErrorMessage.CannotFindStocks()))
        else {
            val walletAssetRoomEntity = currentWalletAsset.copy(units = 1f, goal =1f)
            assetDataBase.insertWalletAssetAll(walletAssetRoomEntity)
            emit(ResultRequest.Success(Unit))
        }

       */
    }

    override suspend fun deleteWalletAsset(code: String) {

      /*  val walletAsset = assetDataBase.findWalletAssetByCode(code.uppercase(Locale.ROOT))
        walletAsset?.let { assetDataBase.deleteWalletAsset(it) }

       */
    }

    override suspend fun hasWalletAsset(code: String): Boolean {
/*
        val walletAsset = assetDataBase.findWalletAssetByCode(code.uppercase(Locale.ROOT))

 */
        return true
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
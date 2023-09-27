package com.example.app.data

import com.example.app.core.request.ErrorMessage
import com.example.app.core.request.RequestState
import com.example.app.core.request.SuccessMessage
import com.example.app.data.adapters.WalletRepositoryAdapter
import com.example.app.data.models.AssetDao
import com.example.app.domain.entities.Asset
import com.example.app.domain.repository.IWalletRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class WalletRepository @Inject constructor(
    private val localRepository: LocalWalletRepository,
    private val webSearchRepository: WebSearchRepository,
    private val walletRepositoryAdapter: WalletRepositoryAdapter
) : IWalletRepository {

    override suspend fun getWallet(): Flow<RequestState<List<Asset>>> = flow {
        val assetsDaoFlow = localRepository.getWallet()
        assetsDaoFlow.collect { assetsDao ->
            val assets = assetsDao.map { assetDao ->
                walletRepositoryAdapter.createAsset(assetDao)
            }
            emit(RequestState.Success(assets))
        }
    }

    override suspend fun getAsset(code: String): Flow<RequestState<Asset>> = flow {
        val assetDaoFlow = localRepository.getAsset(code)

        assetDaoFlow.collect { assetDao ->
            if (assetDao == null) {
                emit(RequestState.Error(ErrorMessage.CannotFindCode()))
            } else {
                val asset = walletRepositoryAdapter.createAsset(assetDao)
                emit(RequestState.Success(asset))
            }
        }
    }

    override suspend fun deleteAsset(code: String): Flow<RequestState<Unit>> = flow {
        val assetDaoFlow = localRepository.getAsset(code)
        assetDaoFlow.collect { assetDao ->
            if (assetDao == null) {
                emit(RequestState.Error(ErrorMessage.CannotFindCode()))
            } else {
                localRepository.deleteAsset(assetDao)
                emit(RequestState.Success(success = SuccessMessage.AssetDelete()))
            }
        }
    }

    suspend fun updateWallet(): RequestState<Unit> {
        /* val walletAsset = localRepository.getWallet()
             ?: return RequestState.Error(ErrorMessage.WalletNotUpdated())

         walletAsset.forEach { asset ->
             val updatedPrice = webSearchRepository.fetchPriceFromWeb(asset.code)

             if (updatedPrice != null) {
                 val updatedAsset = asset.copy(unitPrice = updatedPrice.toFloat())
                 localRepository.deleteAsset(asset)
                 localRepository.addAsset(updatedAsset)
             }
         }


         */
        return RequestState.Success()
    }

    override suspend fun addAsset(
        code: String,
        units: Float,
        goal: Float
    ): Flow<RequestState<Unit>> = flow {
        if (localRepository.assetExists(code))
            emit(RequestState.Error(ErrorMessage.CodeAlreadyAdd()))

        val assetPrice = webSearchRepository.fetchPriceFromWeb(code)

        if (assetPrice == null)
            emit(RequestState.Error(ErrorMessage.CodeNotFound()))
        else {
            val assetDao = AssetDao(code, assetPrice.toFloat(), units, goal)
            localRepository.addAsset(assetDao)

            emit(RequestState.Success(success = SuccessMessage.AssetAdd()))
        }
    }

    override fun getSumOfGoals(): Float {
        /*  val walletAssetModel = localRepository.getWallet()

          if (walletAssetModel != null) {
              return walletAssetModel.map { it.goal }.reduce { acc, goal -> acc + goal }
          }

         */

        return 0f
    }
}
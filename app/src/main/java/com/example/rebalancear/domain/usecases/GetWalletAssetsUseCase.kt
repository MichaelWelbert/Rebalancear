package com.example.rebalancear.domain.usecases


import com.example.rebalancear.core.ResultError
import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.domain.entities.WalletAsset
import com.example.rebalancear.domain.repository.IWalletAssetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWalletAssetsUseCase @Inject constructor(
    private val repository: IWalletAssetRepository
) {
    operator fun invoke(): Flow<ResultRequest<List<WalletAsset>>> = flow {
        try {
            emit(ResultRequest.Loading())
            val assets = repository.getWalletAssets()
            emit(ResultRequest.Success(assets))
        } catch (e: Exception) {
            emit(ResultRequest.Error(ResultError.CannotFindData()))
        }
    }
}
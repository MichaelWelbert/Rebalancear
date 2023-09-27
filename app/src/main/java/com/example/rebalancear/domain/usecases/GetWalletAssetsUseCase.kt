package com.example.rebalancear.domain.usecases


import com.example.app.core.request.ErrorMessage
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
            val assets = repository.getWalletAssets()
            assets.collect { result ->
                when(result) {
                    is ResultRequest.Error -> {
                        emit(ResultRequest.Error(ErrorMessage.ServerErrorMessage()))
                    }
                    is ResultRequest.Loading -> {
                        emit(ResultRequest.Loading())
                    }
                    is ResultRequest.Success -> {
                        emit(ResultRequest.Success(result.data))
                    }
                }
            }
        } catch (e: Exception) {
            emit(ResultRequest.Error(ErrorMessage.ServerErrorMessage()))
        }
    }
}
package com.example.rebalancear.domain.usecases

import com.example.rebalancear.core.ResultError
import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.domain.entities.WalletAsset
import com.example.rebalancear.domain.repository.IWalletAssetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWalletAssetUseCase constructor(
    private val repository: IWalletAssetRepository
) {
    operator fun invoke(code: String): Flow<ResultRequest<WalletAsset>> = flow {

        try {
            if (code.isBlank()) {
                emit(ResultRequest.Error(ResultError.EmptyCode()))
            } else {
                emit(ResultRequest.Loading())
                val asset = repository.getWalletAsset(code)

                if (asset == null)
                    emit(ResultRequest.Error(ResultError.CannotFindAsset()))
                else
                    emit(ResultRequest.Success(asset))
            }

        } catch (e: Exception) {
            emit(ResultRequest.Error(ResultError.CannotFindData()))
        }
    }
}
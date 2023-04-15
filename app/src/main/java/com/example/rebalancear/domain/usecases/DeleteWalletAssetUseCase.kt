package com.example.rebalancear.domain.usecases

import com.example.rebalancear.core.ResultError
import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.domain.repository.IWalletAssetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeleteWalletAssetUseCase @Inject constructor(
    private val repository: IWalletAssetRepository
) {
    operator fun invoke(code: String): Flow<ResultRequest<Unit>> =
        flow {
            emit(ResultRequest.Loading())

            if (!repository.hasWalletAsset(code)) {
                emit(ResultRequest.Error(ResultError.CodeNotFound()))
                return@flow
            }

            repository.deleteWalletAsset(code)
            emit(ResultRequest.Success(Unit))
        }
}
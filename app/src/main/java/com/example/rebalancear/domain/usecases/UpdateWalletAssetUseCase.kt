package com.example.rebalancear.domain.usecases

import com.example.rebalancear.core.ResultError
import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.domain.repository.IWalletAssetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateWalletAssetUseCase @Inject constructor(
    private val repository: IWalletAssetRepository
) {
    operator fun invoke(code: String, units: Double, goal: Double): Flow<ResultRequest<Unit>> =
        flow {
            if (!repository.hasWalletAsset(code)) {
                emit(ResultRequest.Error(ResultError.CodeAlreadyAdd()))
                return@flow
            }

            val updateResult = repository.updateWalletAsset(code, units, goal)

            updateResult.collect { result ->
                when (result) {
                    is ResultRequest.Error -> {
                        emit(ResultRequest.Error(ResultError.CannotFindData()))
                    }
                    is ResultRequest.Loading -> {
                        emit(ResultRequest.Loading())
                    }
                    is ResultRequest.Success -> {
                        emit(ResultRequest.Success(result.data))
                    }
                }
            }
        }
}
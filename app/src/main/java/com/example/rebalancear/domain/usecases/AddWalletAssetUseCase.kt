package com.example.rebalancear.domain.usecases

import com.example.app.core.request.ErrorMessage
import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.domain.repository.IWalletAssetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddWalletAssetUseCase @Inject constructor(
    private val repository: IWalletAssetRepository
) {
    operator fun invoke(code: String, units: Double, goal: Double): Flow<ResultRequest<Unit>> =
        flow {
            if (repository.hasWalletAsset(code)) {
                emit(ResultRequest.Error(ErrorMessage.CodeAlreadyAdd()))
                return@flow
            }

            val addResult = repository.addWalletAsset(code, units, goal)

            addResult.collect { result -> emit(result)}
        }
}
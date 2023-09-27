package com.example.app.domain.usecases

import com.example.app.core.request.RequestState
import com.example.app.domain.repository.IWalletRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeleteAssetUseCase @Inject constructor(
    private val repository: IWalletRepository
) {
    operator fun invoke(code: String): Flow<RequestState<Unit>> = flow {
        val deleteFlow = repository.deleteAsset(code)
        deleteFlow.collect { emit(it) }
    }
}
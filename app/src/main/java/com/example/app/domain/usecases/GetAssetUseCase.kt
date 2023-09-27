package com.example.app.domain.usecases

import com.example.app.core.request.RequestState
import com.example.app.domain.entities.Asset
import com.example.app.domain.repository.IWalletRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAssetUseCase @Inject constructor(
    private val repository: IWalletRepository
) {
    operator fun invoke(code: String): Flow<RequestState<Asset>> = flow {
        val getFlow = repository.getAsset(code)
        getFlow.collect { emit(it) }
    }

}
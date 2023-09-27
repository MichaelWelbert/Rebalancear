package com.example.app.domain.usecases

import com.example.app.core.request.ErrorMessage
import com.example.app.core.request.RequestState
import com.example.app.domain.entities.Asset
import com.example.app.domain.repository.IWalletRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPatrimonyUseCase @Inject constructor(
    private val repository: IWalletRepository
) {
    operator fun invoke(): Flow<RequestState<Float>> = flow  {
        val getFlow = repository.getWallet()

        getFlow.collect {request ->
            when(request) {
                is RequestState.Error ->  {}
                is RequestState.Success -> {
                    if(request.data == null) {
                        emit(RequestState.Error(ErrorMessage.CannotFindPatrimony()))
                        return@collect
                    }

                    if (request.data.isEmpty()) {
                        emit(RequestState.Success(0f))
                        return@collect
                    }

                    val assetValueInvested =request.data.map { asset -> asset.units * asset.unitPrice }
                    val patrimony =  assetValueInvested.reduce { acc, value -> acc + value }
                    emit(RequestState.Success(patrimony))
                }
            }

        }
    }
}
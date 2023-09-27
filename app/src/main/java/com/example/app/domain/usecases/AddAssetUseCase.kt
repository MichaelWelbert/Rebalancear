package com.example.app.domain.usecases

import com.example.app.core.request.ErrorMessage
import com.example.app.core.request.RequestState
import com.example.app.domain.repository.IWalletRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddAssetUseCase @Inject constructor(
    private val repository: IWalletRepository
) {
    operator fun invoke(code: String, units: Float, goal: Float): Flow<RequestState<Unit>> =
        flow {

            if (!isAValidGoal(goal))
                emit(RequestState.Error(ErrorMessage.InvalidGoal()))


            if (!isAValidUnit(units))
                emit(RequestState.Error(ErrorMessage.InvalidUnit()))


            val addFlow = repository.addAsset(code, units, goal)
            addFlow.collect { emit(it) }
        }


    private fun isAValidGoal(goal: Float): Boolean {
        val isOutOfRange = goal < 0f || goal > 1f

        if (isOutOfRange)
            return false

        val sumOfGoals = repository.getSumOfGoals()
        return goal + sumOfGoals <= 1f
    }

    private fun isAValidUnit(units: Float): Boolean {
        return units > 0
    }
}
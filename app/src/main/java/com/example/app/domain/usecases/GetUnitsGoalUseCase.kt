package com.example.app.domain.usecases

import android.util.Log
import javax.inject.Inject
import kotlin.math.ceil

class GetUnitsGoalUseCase @Inject constructor() {
    operator fun invoke(
        patrimony: Float,
        unitsPrice: Float,
        percentGoal: Float,
        percentOwned: Float,
    ): Float {

        val allocatedCurrentValue = patrimony * percentOwned
        val allocatedDesireValue = patrimony * percentGoal

        val alreadyReachedGoal = allocatedCurrentValue >= allocatedDesireValue

        if (alreadyReachedGoal)
            return 0f


        val diffBetweenDesiredAndObtained = (allocatedCurrentValue - allocatedDesireValue)
        val totalToReachGoal = diffBetweenDesiredAndObtained / (percentGoal - 1.0f)
        val amountGoal = allocatedCurrentValue + totalToReachGoal

        return ceil((amountGoal / unitsPrice))
    }
}

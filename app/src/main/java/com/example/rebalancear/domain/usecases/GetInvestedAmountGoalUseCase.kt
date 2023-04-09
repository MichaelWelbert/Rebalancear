package com.example.rebalancear.domain.usecases

import javax.inject.Inject

class GetInvestedAmountGoalUseCase @Inject constructor() {
    operator fun invoke(
        patrimony: Double,
        percentGoal: Double,
        percentOwned: Double,
    ): Double {
        val percentGoalFormat = (percentGoal / 100)
        val percentOwnedFormat = (percentOwned / 100)
        val allocatedCurrentValue = patrimony * percentOwnedFormat
        val allocatedDesireValue = patrimony * percentGoalFormat

        val alreadyReachedGoal = allocatedCurrentValue >= allocatedDesireValue

        return if(alreadyReachedGoal) {
            allocatedCurrentValue - (allocatedCurrentValue - allocatedDesireValue)
        } else {
            val diffBetweenDesiredAndObtained = (allocatedCurrentValue - allocatedDesireValue)
            val totalToReachGoal = diffBetweenDesiredAndObtained / (percentGoalFormat - 1.0)
            allocatedCurrentValue + totalToReachGoal
        }
    }
}
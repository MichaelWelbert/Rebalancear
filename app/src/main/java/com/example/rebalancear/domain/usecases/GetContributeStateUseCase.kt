package com.example.rebalancear.domain.usecases


import com.example.rebalancear.domain.status.ContributeStatus
import javax.inject.Inject

class GetContributeStateUseCase @Inject constructor() {
    operator fun invoke(percentOwned: Double, percentGoal: Double): ContributeStatus {
        return if(percentOwned >= percentGoal)
            ContributeStatus.WAIT
        else
            ContributeStatus.CONTRIBUTE
    }
}
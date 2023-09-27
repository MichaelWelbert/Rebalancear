package com.example.rebalancear.domain.usecases

import javax.inject.Inject

class GetPercentageOwnedUseCase @Inject constructor() {
    operator fun invoke(patrimony: Double, investedAmount: Double): Double {
        if (patrimony <= 0f)
            return 0.0

        if (investedAmount <= 0f)
            return 0.0

        return ((investedAmount / patrimony) * 100)
    }
}
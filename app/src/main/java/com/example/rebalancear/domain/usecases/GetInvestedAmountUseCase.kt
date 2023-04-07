package com.example.rebalancear.domain.usecases

import javax.inject.Inject

class GetInvestedAmountUseCase @Inject constructor() {
    operator fun invoke(units: Double, unitsPrice: Double): Double {
        if (units <= 0.00f)
            return 0.0

        if (unitsPrice <= 0.00f)
            return 0.0

        return units * unitsPrice
    }
}
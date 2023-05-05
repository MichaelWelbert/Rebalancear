package com.example.rebalancear.domain.usecases

import android.util.Log
import javax.inject.Inject
import kotlin.math.sqrt

class GetGrahamFairPriceUseCase @Inject constructor() {
    operator fun invoke(
        LPA: Double,
        VPA: Double,
    ): Double {
        if (LPA <= 0 || VPA <= 0)
            return 0.0

        val grahamConst = 22.5
        return sqrt((grahamConst * LPA * VPA))
    }
}
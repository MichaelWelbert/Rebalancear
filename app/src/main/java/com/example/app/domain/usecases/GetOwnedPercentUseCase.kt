package com.example.app.domain.usecases

import javax.inject.Inject

class GetOwnedPercentUseCase @Inject constructor() {
    operator fun invoke(patrimony: Float, units: Float, unitsPrice: Float): Float {
        if (units <= 0f)
            return 0f

        if (unitsPrice <= 0f)
            return 0f

        if (patrimony <= 0f)
            return 0f

        val owned = ((unitsPrice * units / patrimony))

        return String.format("%.2f", owned).replace(',', '.').toFloat()
    }
}
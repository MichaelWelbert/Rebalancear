package com.example.rebalancear.domain.usecases

import com.example.rebalancear.core.AssetType
import javax.inject.Inject
import kotlin.math.ceil


class GetUnitGoalUseCase @Inject constructor() {
    operator fun invoke(
        price: Double,
        investedAmountGoal: Double,
        assetType: AssetType
    ): Double {

        if (price <= 0)
            return 0.0


        var units = investedAmountGoal / price

        if (assetType == AssetType.NATIONAL_STOCKS)
            units = ceil(units)

        return units
    }
}
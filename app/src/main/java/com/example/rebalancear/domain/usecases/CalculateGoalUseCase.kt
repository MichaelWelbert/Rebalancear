package com.example.rebalancear.domain.usecases

import com.example.rebalancear.domain.entities.WalletAsset
import javax.inject.Inject

class CalculateGoalUseCase @Inject constructor() {
    operator fun invoke(walletAssets: List<WalletAsset>): Double {
        if (walletAssets.isEmpty())
            return 0.0

        val assetGoals = walletAssets.map { asset -> asset.percentGoal }

        return  assetGoals.reduce { acc, value -> acc + value }
    }
}
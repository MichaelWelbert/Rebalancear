package com.example.rebalancear.domain.usecases

import com.example.rebalancear.domain.entities.WalletAsset
import javax.inject.Inject

class CalculatePatrimonyUseCase @Inject constructor() {
    operator fun invoke(walletAssets: List<WalletAsset>): Double {
        if (walletAssets.isEmpty())
            return 0.0

        val assetValueInvested = walletAssets.map { asset -> asset.units * asset.unitPrice }

        return assetValueInvested.reduce { acc, value -> acc + value }
    }
}
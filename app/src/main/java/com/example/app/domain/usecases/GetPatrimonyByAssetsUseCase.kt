package com.example.app.domain.usecases

import com.example.app.domain.entities.Asset
import javax.inject.Inject

class GetPatrimonyByAssetsUseCase @Inject constructor() {
    operator fun invoke(walletAssets: List<Asset>): Float {
        if (walletAssets.isEmpty())
            return 0f

        val assetValueInvested = walletAssets.map { asset -> asset.units * asset.unitPrice }

        return assetValueInvested.reduce { acc, value -> acc + value }
    }
}
package com.example.rebalancear.data.adapters

import com.example.rebalancear.data.models.WalletAssetPriceModel
import com.example.rebalancear.data.room.entities.WalletAssetRoomEntity
import com.example.rebalancear.domain.entities.WalletAsset
import javax.inject.Inject

class WalletAssetAdapter @Inject constructor() {
    fun buildWalletAssets(
        userAssetInfo: WalletAssetRoomEntity,
        assetPriceModel: WalletAssetPriceModel
    ): WalletAsset {
        return WalletAsset(
            code = userAssetInfo.code,
            units = userAssetInfo.units,
            percentGoal = userAssetInfo.goal,
            unitPrice = assetPriceModel.unitPrice,
        )
    }
}
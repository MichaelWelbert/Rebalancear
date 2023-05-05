package com.example.rebalancear.data.adapters

import com.example.rebalancear.data.models.WalletAssetModel
import com.example.rebalancear.data.room.entities.WalletAssetRoomEntity
import com.example.rebalancear.domain.entities.WalletAsset
import javax.inject.Inject

class WalletAssetAdapter @Inject constructor() {
    fun buildWalletAssets(
        userAssetInfo: WalletAssetRoomEntity,
        assetModel: WalletAssetModel
    ): WalletAsset {
        return WalletAsset(
            code = userAssetInfo.code,
            units = userAssetInfo.units,
            percentGoal = userAssetInfo.goal,
            unitPrice = assetModel.unitPrice,
            LPA = assetModel.LPA,
            VPA = assetModel.VPA
        )
    }
}
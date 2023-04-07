package com.example.rebalancear.data.adapters

import com.example.rebalancear.data.room.entities.WalletAssetModel
import com.example.rebalancear.domain.entities.WalletAsset
import javax.inject.Inject

class WalletAssetAdapter  @Inject constructor() {
    fun buildWalletAssets(walletAssetsModels: List<WalletAssetModel>) : List<WalletAsset> {
        return walletAssetsModels.map {
            WalletAsset(
                code = it.code,
                units = it.units
            )
        }
    }
}
package com.example.app.data.adapters

import com.example.app.data.models.AssetDao
import com.example.app.domain.entities.Asset
import javax.inject.Inject

class WalletRepositoryAdapter @Inject constructor() {

    fun createAsset(assetDao: AssetDao): Asset {
        return Asset(
            assetDao.code,
            assetDao.unitPrice,
            assetDao.units,
            assetDao.goal
        )
    }
}
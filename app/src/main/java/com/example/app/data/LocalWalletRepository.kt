package com.example.app.data

import com.example.app.data.models.AssetDao
import com.example.app.data.room.dao.AssetDataDao
import com.example.app.data.room.entities.WalletAssetRoomEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalWalletRepository @Inject constructor(
    private val assetDataBase: AssetDataDao,
) {
    suspend fun getWallet(): Flow<List<AssetDao>> = flow {
        assetDataBase.getWalletAssetAll().collect { userAssetsInfo ->
            val assets = userAssetsInfo.map { userAssetInfo ->
                AssetDao(
                    code = userAssetInfo.code,
                    units = userAssetInfo.units,
                    unitPrice = userAssetInfo.unitPrice,
                    goal = userAssetInfo.goal
                )
            }

            emit(assets)
        }
    }

    suspend fun assetExists(code: String): Boolean {
        return assetDataBase.findWalletAssetByCode(code) != null
    }

    suspend fun getAsset(code: String): Flow<AssetDao?> = flow {
        val assetRoom = assetDataBase.findWalletAssetByCode(code)

        if (assetRoom == null) {
            emit(null)
        } else {
            val asset = AssetDao(
                code = assetRoom.code,
                units = assetRoom.units,
                unitPrice = assetRoom.unitPrice,
                goal = assetRoom.goal
            )

            emit(asset)
        }
    }

    suspend fun addAsset(assetDao: AssetDao) {
        val assetRoom = WalletAssetRoomEntity(
            code = assetDao.code,
            units = assetDao.units,
            unitPrice = assetDao.unitPrice,
            goal = assetDao.goal
        )

        assetDataBase.insertWalletAssetAll(assetRoom)
    }

    suspend fun deleteAsset(assetDao: AssetDao) {
        val assetRoom = WalletAssetRoomEntity(
            code = assetDao.code,
            units = assetDao.units,
            unitPrice = assetDao.unitPrice,
            goal = assetDao.goal
        )

        assetDataBase.deleteWalletAsset(assetRoom)
    }
}
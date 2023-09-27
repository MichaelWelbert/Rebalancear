package com.example.app.domain.repository

import com.example.app.core.request.RequestState
import com.example.app.domain.entities.Asset
import kotlinx.coroutines.flow.Flow


interface IWalletRepository {
    suspend fun addAsset(code: String, units: Float, goal: Float): Flow<RequestState<Unit>>

    suspend fun deleteAsset(code: String): Flow<RequestState<Unit>>

    suspend fun getWallet(): Flow<RequestState<List<Asset>>>

    suspend fun getAsset(code: String): Flow<RequestState<Asset>>

    fun getSumOfGoals(): Float

}
package com.example.rebalancear.di.viewmodel

import android.content.Context
import androidx.room.Room
import com.example.rebalancear.data.WalletAssetRepository
import com.example.rebalancear.data.room.dao.WalletAssetDao
import com.example.rebalancear.data.room.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class DataBaseModel {
    @Provides
    @ViewModelScoped
    fun provideAppDatabaseRepository(
        @ApplicationContext applicationContext: Context,
    ): WalletAssetDao {
        val db = Room.databaseBuilder(
            applicationContext, AppDatabase::class.java, "BalancearDatabase"
        ).build()

        return db.walletAssetDao()
    }


}
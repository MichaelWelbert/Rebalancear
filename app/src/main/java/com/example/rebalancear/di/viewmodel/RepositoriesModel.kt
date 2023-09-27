package com.example.rebalancear.di.viewmodel

import com.example.app.data.WalletRepository
import com.example.app.domain.repository.IWalletRepository
import com.example.rebalancear.data.WalletAssetRepository
import com.example.rebalancear.domain.repository.IWalletAssetRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModel {
    @Binds
    @ViewModelScoped
    abstract fun provideIWalletAssetRepository(
        repositoryImpl : WalletAssetRepository
    ): IWalletAssetRepository

    @Binds
    @ViewModelScoped
    abstract fun provideIWalletRepository(
        repositoryImpl : WalletRepository
    ): IWalletRepository
}
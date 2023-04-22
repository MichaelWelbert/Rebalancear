package com.example.rebalancear.di.viewmodel

import com.example.rebalancear.data.yahoofinance.YahooFinanceClient
import android.content.Context
import com.example.rebalancear.data.yahoofinance.IMarket
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ApiModel {
    @Provides
    @ViewModelScoped
    fun provideApiCliente(
        @ApplicationContext applicationContext: Context,
    ): IMarket {
        return YahooFinanceClient(apiKey)
    }

    companion object {
        private const val apiKey =
            "7c42dbe9c8msh88fb8327c8c9c4fp1d6cb5jsnb2f8c1a72539"
    }
}
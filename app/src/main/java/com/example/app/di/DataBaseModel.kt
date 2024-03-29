package com.example.app.di

import android.content.Context
import androidx.room.Room
import com.example.app.data.room.dao.AssetDataDao
import com.example.app.data.room.database.AppDatabase
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
    ): AssetDataDao {
        val db = Room.databaseBuilder(
            applicationContext, AppDatabase::class.java, "DataBase"
        ).build()

        return db.assetDataDao()
    }


}
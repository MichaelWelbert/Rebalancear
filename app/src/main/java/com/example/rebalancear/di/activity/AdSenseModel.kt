package com.example.rebalancear.di.activity

import android.content.Context
import com.example.rebalancear.presentation.adsense.IAdSense
import com.example.rebalancear.presentation.adsense.admob.AdMob
import com.example.rebalancear.presentation.adsense.admob.AdMobAppOpen
import com.example.rebalancear.presentation.adsense.admob.AdMobBanner
import com.example.rebalancear.presentation.adsense.admob.AdMobInterstitial
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class AdSenseModel {
    @Provides
    @ActivityRetainedScoped
    fun provideAdMob(
        @ApplicationContext context: Context,
    ): IAdSense {
        return AdMob(
            context,
            adMobAppOpen = AdMobAppOpen(adUnitIdAppOpen),
            adMobInterstitial = AdMobInterstitial(adUnitIdIntertitial),
            adMobBanner = AdMobBanner(adUnitIdBanner)
        )
    }

    companion object {
        private const val adUnitIdIntertitial = "ca-app-pub-3940256099942544/1033173712"
        private const val adUnitIdAppOpen = "ca-app-pub-3940256099942544/3419835294"
        private const val adUnitIdBanner = "ca-app-pub-3940256099942544/6300978111"
    }
}
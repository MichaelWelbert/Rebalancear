package com.example.rebalancear.presentation.adsense.admob

import android.app.Activity
import android.content.Context
import com.example.rebalancear.presentation.adsense.IAdSense
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class AdMob @Inject constructor(
    @ApplicationContext private val context: Context,
    private val adMobAppOpen: AdMobAppOpen,
    private val adMobInterstitial: AdMobInterstitial,
    private val adMobBanner: AdMobBanner,
) : IAdSense {

    init {
        MobileAds.initialize(context)
        loadInterticialAd(context)

    }

    override fun loadAppOpenAd(context: Context) {
        adMobAppOpen.loadAd(context)
    }

    override fun showAppOpenAd(activity: Activity) {
        val appOpenAd =adMobAppOpen.getAppOpenAd()
        appOpenAd?.show(activity)
    }

    override fun loadInterticialAd(context: Context) {
        adMobInterstitial.loadInterstitial(context)
    }

    override fun showInterticialAd(activity: Activity) {
        val insterticial = adMobInterstitial.getInterstitial()
        insterticial?.show(activity)
    }

    override fun getBannerWithHeightAd(
        context: Context,
        adSizeMaxHeight: Float
    ): AdView {
        return adMobBanner.getBannerWithHeight(context, adSizeMaxHeight)
    }


    override fun getBannerAd(
        context: Context,
        horizontalPadding: Float,
    ): AdView {
        return adMobBanner.getBanner(context, horizontalPadding)
    }
}
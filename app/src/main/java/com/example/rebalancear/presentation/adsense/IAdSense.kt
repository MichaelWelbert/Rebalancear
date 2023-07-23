package com.example.rebalancear.presentation.adsense

import android.app.Activity
import android.content.Context
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

interface IAdSense {
    fun loadAppOpenAd(context: Context)
    fun showAppOpenAd(activity: Activity)
    fun loadInterticialAd(context: Context)
    fun showInterticialAd(activity: Activity)
    fun getBannerAd(
        context: Context,
        horizontalPadding: Float,
    ): AdView

    fun getBannerWithHeightAd(
        context: Context,
        adSizeMaxHeight: Float,
    ): AdView
}
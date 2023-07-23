package com.example.rebalancear.presentation.adsense.admob

import android.app.Activity
import android.content.Context
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError

import com.google.android.gms.ads.appopen.AppOpenAd
import javax.inject.Inject


class AdMobAppOpen @Inject constructor(
    private val adUnit: String,
) {
    private var appOpenAd: AppOpenAd? = null
    private var isLoadingAd = false
    private var isShowingAd = false
    private val isAdAvailable: Boolean
        get() = appOpenAd != null

    fun loadAd(context: Context) {
        if (isLoadingAd || isAdAvailable) {
            return
        }

        isLoadingAd = true
        val request = AdRequest.Builder().build()
        AppOpenAd.load(
            context,
            adUnit,
            request,
            object : AppOpenAd.AppOpenAdLoadCallback() {
                override fun onAdLoaded(ad: AppOpenAd) {
                    appOpenAd = ad
                    isLoadingAd = false
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    isLoadingAd = false
                }
            }
        )
    }


    fun getAppOpenAd() :AppOpenAd? {
        return appOpenAd
    }
}

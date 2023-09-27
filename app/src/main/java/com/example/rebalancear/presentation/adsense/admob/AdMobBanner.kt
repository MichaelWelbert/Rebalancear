package com.example.rebalancear.presentation.adsense.admob

import android.content.Context
import android.graphics.Color
import android.util.DisplayMetrics
import android.view.WindowManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import javax.inject.Inject

class AdMobBanner @Inject constructor(
    private val adUnit: String,
) {
    fun getBanner(
        context: Context,
        horizontalPadding: Float,
    ): AdView {
        return AdView(context).apply {
            val width = getDisplayMaxWidth(context) - horizontalPadding
            setAdSize(
                AdSize.getCurrentOrientationInlineAdaptiveBannerAdSize(
                    context,
                    width.toInt()
                )
            )
            adUnitId = adUnit
            loadAd(AdRequest.Builder().build())
        }
    }

    fun getBannerWithHeight(
        context: Context,
        adSizeMaxHeight: Float
    ): AdView {
        return AdView(context).apply {
            val width = getDisplayMaxWidth(context)
            setAdSize(AdSize.getInlineAdaptiveBannerAdSize(width.toInt(), adSizeMaxHeight.toInt()))
            adUnitId = adUnit
            loadAd(AdRequest.Builder().build())
            setBackgroundColor(Color.TRANSPARENT)
        }
    }

    private fun getDisplayMaxWidth(context: Context): Float {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()

        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val widthPixels = displayMetrics.widthPixels
        val density = displayMetrics.density

        return (widthPixels / density)
    }
}

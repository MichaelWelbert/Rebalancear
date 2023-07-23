package com.example.rebalancear.presentation.screen.adMob

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.rebalancear.presentation.adsense.IAdSense
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

@Composable
fun BannerAdView(
    adsense: IAdSense,
    horizontalPadding: Float = 0f,
) {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .background(RebalanceColors.whiteColor),
        factory = { context ->
            adsense.getBannerAd(
                context,
                horizontalPadding,
            )
        },
    )
}


@Composable
fun BannerAdViewWithMaxHeight(
    adsense: IAdSense,
    adSizeMaxHeight: Float = 0f,
) {
    AndroidView(
        modifier = Modifier.fillMaxWidth().background(RebalanceColors.primaryColor),
        factory = { context ->
            adsense.getBannerWithHeightAd(
                context,
                adSizeMaxHeight
            )
        },
    )
}
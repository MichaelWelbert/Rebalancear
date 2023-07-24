package com.example.rebalancear.presentation.adsense

import android.app.Activity
import com.example.rebalancear.routes.Routes

object RouteTriggeredAdDisplay {

    private var lastnavRoute: Routes? = null
    private var routeCount: Int = 0
    private const val routeSwitchesNeededToShowAd: Int = 10
    private const val routeSwitchesNeededToLoadNewAd: Int = 8


    fun onRouteSwitch(route: Routes, adsense: IAdSense, activity: Activity) {
        when (route) {
            Routes.InterstitialScreen -> Unit
            Routes.IntroScreen -> Unit
            Routes.AssetScreen -> {
                onRouteSwitch(
                    currentRoute = Routes.AssetScreen,
                    activity = activity,
                    adSense = adsense
                )
            }
            Routes.SplashScreen -> adsense.loadAppOpenAd(activity)
            Routes.WalletScreen -> {
                onRouteSwitch(
                    currentRoute = Routes.WalletScreen,
                    activity = activity,
                    adSense = adsense
                )
                adsense.showAppOpenAd(activity)
            }
        }
    }


    private fun onRouteSwitch(
        currentRoute: Routes,
        activity: Activity,
        adSense: IAdSense,
    ) {
        val isRouteSwitchToAValidRoute = isRouteSwitchToAValidRoute(
            currentRoute = currentRoute,
            lastRoute = lastnavRoute,
        )

        if(isRouteSwitchToAValidRoute)
            routeCount += 1


        if (routeCount == routeSwitchesNeededToLoadNewAd) {
            adSense.loadInterticialAd(activity)
        }

        if (routeCount >= routeSwitchesNeededToShowAd) {
            adSense.showInterticialAd(activity)
            resetRouteCount()
        }
    }

    private fun resetRouteCount() {
        routeCount = 0
    }

    private fun isRouteSwitchToAValidRoute(
        currentRoute: Routes,
        lastRoute: Routes?,
    ): Boolean {
        if (currentRoute == lastRoute)
            return false

        lastnavRoute = currentRoute

        return when (currentRoute) {
            Routes.IntroScreen,
            Routes.InterstitialScreen,
            Routes.SplashScreen -> false
            Routes.WalletScreen,
            Routes.AssetScreen -> true
        }
    }

}
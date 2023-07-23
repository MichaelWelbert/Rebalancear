package com.example.rebalancear.routes

import android.annotation.SuppressLint
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.rebalancear.presentation.adsense.IAdSense
import com.example.rebalancear.presentation.adsense.RouteTriggeredInterstitialAdDisplay
import com.example.rebalancear.presentation.screen.asset.AssetScreenComponent
import com.example.rebalancear.presentation.screen.intro.IntroScreenComponent
import com.example.rebalancear.presentation.screen.splash.SplashScreenComponent
import com.example.rebalancear.presentation.screen.wallet.WalletScreenComponent
import com.example.rebalancear.presentation.viewmodels.AssetViewModel
import com.example.rebalancear.presentation.viewmodels.WalletViewModel

sealed class Routes(val route: String) {
    object WalletScreen : Routes(route = "wallet_screen")
    object AssetScreen : Routes(route = "asset_screen")
    object SplashScreen : Routes(route = "splash_screen")
    object IntroScreen : Routes(route = "intro_screen")
    object InterstitialScreen : Routes(route = "intertitial_screen")
}


@SuppressLint("RememberReturnType")
@Composable
fun MakeRoutes(
    navController: NavHostController,
    adSense: IAdSense,
) {
    val context = LocalContext.current


    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ) {


        composable(
            route = Routes.SplashScreen.route
        ) {
            SplashScreenComponent(navController = navController)
            adSense.loadAppOpenAd(context)
        }

        composable(
            route = Routes.IntroScreen.route
        ) {
            IntroScreenComponent(navController = navController)
        }

        composable(
            route = Routes.WalletScreen.route
        ) {

            if(context is Activity){
                RouteTriggeredInterstitialAdDisplay.onRouteSwitch(
                    currentRoute = Routes.WalletScreen,
                    activity = context,
                    adSense = adSense
                )
            }

            val viewmodel: WalletViewModel = hiltViewModel()
            WalletScreenComponent(navController,  adSense, viewmodel)

            if(context is Activity) {
                adSense.showAppOpenAd(context)
            }
        }

        composable(
            route = Routes.AssetScreen.route + "/{code}",
            arguments = listOf(navArgument("code") { type = NavType.StringType })
        ) { backStackEntry ->

            if(context is Activity){
                RouteTriggeredInterstitialAdDisplay.onRouteSwitch(
                    currentRoute = Routes.AssetScreen,
                    activity = context,
                    adSense = adSense
                )
            }

            val viewmodel: AssetViewModel = hiltViewModel()
            val code = backStackEntry.arguments?.getString("code")
            remember {
                viewmodel.loadWalletAssets(code)
            }
            AssetScreenComponent(
                navController = navController,
                assetViewModel = viewmodel
            )
        }
    }
}



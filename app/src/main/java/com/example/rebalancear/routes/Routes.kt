package com.example.rebalancear.routes

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.app.presentation.events.AssetEvent
import com.example.app.presentation.events.WalletEvent
import com.example.app.presentation.ui.screens.AssetScreen
import com.example.app.presentation.ui.screens.WalletScreen
import com.example.app.presentation.viewmodels.AssetViewModel
import com.example.app.presentation.viewmodels.WalletViewModel
import com.example.rebalancear.presentation.adsense.IAdSense
import com.example.rebalancear.presentation.screen.intro.IntroScreenComponent
import com.example.rebalancear.presentation.screen.splash.SplashScreenComponent



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
    onLoad: (route: Routes) -> Unit,
    adSense: IAdSense,
) {

    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ) {


        composable(
            route = Routes.SplashScreen.route
        ) {
            SplashScreenComponent(navController = navController)
            onLoad(Routes.SplashScreen)
        }

        composable(
            route = Routes.IntroScreen.route
        ) {
            IntroScreenComponent(navController = navController)
            onLoad(Routes.IntroScreen)
        }

        composable(
            route = Routes.WalletScreen.route
        ) {

            val viewmodel: WalletViewModel = hiltViewModel()
            viewmodel.onEvent(WalletEvent.OnLoadWallet)

            WalletScreen(
                navController = navController,
                wallet = viewmodel.wallet,
                addAssetState = viewmodel.addAssetDialogState,
                onEvent = viewmodel::onEvent
            )
            onLoad(Routes.WalletScreen)
        }

        composable(
            route = Routes.AssetScreen.route + "/{code}",
            arguments = listOf(navArgument("code") { type = NavType.StringType })
        ) { backStackEntry ->

            val viewmodel: AssetViewModel = hiltViewModel()
            val code = backStackEntry.arguments?.getString("code") ?: return@composable //TODO: Tratar pagina error
            viewmodel.onEvent(AssetEvent.OnLoadAsset(code = code))
            val asset = viewmodel.asset

            AssetScreen(
                navController =  navController,
                asset = asset,
                onEvent = viewmodel::onEvent
            )
            onLoad(Routes.AssetScreen)
        }
    }
}



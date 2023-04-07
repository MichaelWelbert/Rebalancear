package com.example.rebalancear.routes

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.rebalancear.presentation.screen.asset.AssetScreenComponent
import com.example.rebalancear.presentation.screen.wallet.WalletScreenComponent

sealed class Routes(val route: String) {
    object WalletScreen : Routes(route = "wallet_screen")
    object AddAssetScreen : Routes(route = "add_asset_screen")
    object AssetScreen : Routes(route = "asset_screen")
}

@Composable
fun MakeRoutes(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.WalletScreen.route
    ) {
        composable(
            route = Routes.WalletScreen.route
        ) {
            Log.d("michael", "entrou1")
            WalletScreenComponent(navController, hiltViewModel())
        }

        composable(
            route = Routes.AssetScreen.route + "/{code}",
            arguments = listOf(navArgument("code") { type = NavType.StringType })
        ) { backStackEntry ->

            AssetScreenComponent(
                navController = navController,
            )
        }
    }
}

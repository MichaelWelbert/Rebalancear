package com.example.rebalancear.routes

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.rebalancear.presentation.screen.asset.AssetScreenComponent
import com.example.rebalancear.presentation.screen.wallet.WalletScreenComponent
import com.example.rebalancear.presentation.viewmodels.AssetViewModel
import com.example.rebalancear.presentation.viewmodels.WalletViewModel

sealed class Routes(val route: String) {
    object WalletScreen : Routes(route = "wallet_screen")
    object AssetScreen : Routes(route = "asset_screen")
}

@SuppressLint("RememberReturnType")
@Composable
fun MakeRoutes(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.WalletScreen.route
    ) {
        composable(
            route = Routes.WalletScreen.route
        ) {
            val viewmodel: WalletViewModel = hiltViewModel()
            WalletScreenComponent(navController, viewmodel)
        }

        composable(
            route = Routes.AssetScreen.route + "/{code}",
            arguments = listOf(navArgument("code") { type = NavType.StringType })
        ) { backStackEntry ->

            val viewmodel: AssetViewModel = hiltViewModel()
            val code = backStackEntry.arguments?.getString("code")
            remember {
                viewmodel.loadWalletAssets(code)
            }
            AssetScreenComponent(
                navController = navController,
                assetViewModel =  viewmodel
            )
        }
    }
}

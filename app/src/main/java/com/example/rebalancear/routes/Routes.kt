package com.example.rebalancear.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rebalancear.presentation.components.addAssetScreen.AddAssetScreen
import com.example.rebalancear.presentation.components.walletScreen.WalletScreenComponent
import com.example.rebalancear.presentation.viewmodels.WalletViewModel

sealed class Routes(val route: String){
    object WalletScreen: Routes(route = "wallet_screen")
    object AddAssetScreen: Routes(route = "add_asset_screen")
}

@Composable
fun MakeRoutes(navController: NavHostController) {
    val viewModel = WalletViewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.WalletScreen.route
    ) {
        composable(
            route = Routes.WalletScreen.route
        ) {
            WalletScreenComponent(navController, walletViewModel = viewModel)
        }
        composable(
            route = Routes.AddAssetScreen.route
        ) {
            AddAssetScreen()
        }
    }
}

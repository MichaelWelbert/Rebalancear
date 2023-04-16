package com.example.rebalancear.presentation.screen.wallet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import com.example.rebalancear.presentation.events.WalletAssetNavigationEvent
import com.example.rebalancear.presentation.events.WalletAssetScreenEvents
import com.example.rebalancear.presentation.viewmodels.WalletViewModel
import com.example.rebalancear.routes.Routes
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun WalletScreenNavigationComponent(
    navController: NavController,
    navigationEvent: SharedFlow<WalletAssetNavigationEvent>,
) {
    HandleNavigationParameters(navController)

    LaunchedEffect(key1 = Unit) {
        navigationEvent.onEach { navigationEvent ->
            when (navigationEvent) {
                is WalletAssetNavigationEvent.OnNavigationAsset -> {
                    navController.navigate(Routes.AssetScreen.route + "/${navigationEvent.code}")
                }
            }

        }.launchIn(this)
    }
}

@Composable
private fun HandleNavigationParameters(
    navController: NavController,
    walletViewModel: WalletViewModel = hiltViewModel(),
) {
    val savedStateHandler = navController.currentBackStackEntry?.savedStateHandle?: return

    TryReloadPageOnDeleteAsset(
        savedStateHandler,
        walletViewModel,
        onReload = { disableRefreshOnStateHandler(navController) }
    )
}


@Composable
private fun TryReloadPageOnDeleteAsset(
    saveStateHandler: SavedStateHandle,
    walletViewModel: WalletViewModel = hiltViewModel(),
    onReload: () -> Unit,
) {
    saveStateHandler.getStateFlow<Boolean?>("refreshOnDelete", false)
        .collectAsState().value?.let {
            if (it) {
                walletViewModel.onTriggerEvent(event = WalletAssetScreenEvents.RefreshPage)
                onReload()
            }
        }
}

private fun disableRefreshOnStateHandler(navController: NavController) {
    navController.currentBackStackEntry?.savedStateHandle?.set("refreshOnDelete", false)
}
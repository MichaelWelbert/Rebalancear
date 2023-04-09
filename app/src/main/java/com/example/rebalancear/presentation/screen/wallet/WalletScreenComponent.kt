package com.example.rebalancear.presentation.screen.wallet

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rebalancear.presentation.events.WalletAssetScreenEvents
import com.example.rebalancear.presentation.screen.wallet.components.TopbarContent
import com.example.rebalancear.presentation.screen.wallet.components.WalletAssetCardsContent
import com.example.rebalancear.presentation.ui.theme.RebalanceColors
import com.example.rebalancear.presentation.states.PageState
import com.example.rebalancear.presentation.viewmodels.WalletViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun WalletScreenComponent(
    navController: NavController,
    walletViewModel: WalletViewModel,
) {
    val walletState = walletViewModel.walletState

    when (walletState.state) {
        is PageState.Error -> {}
        is PageState.Loading -> {}
        is PageState.Success -> {
            Scaffold(
                topBar = {
                    TopbarContent(walletState.state.data.patrimony)
                },
                content = { innerPadding ->
                    WalletAssetCardsContent(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(RebalanceColors.neutral500)
                            .padding(8.dp),
                        walletAssets = walletState.state.data.assets,
                        navController = navController,
                        onAddwalleAssetCard = { code, units ->
                            walletViewModel.onTriggerEvent(
                                WalletAssetScreenEvents.OnAddWalletAsset(code = code, units = units)
                            )
                        }
                    )
                }
            )
        }
        is PageState.Undefined -> {}
    }

}


package com.example.rebalancear.presentation.screen.wallet

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rebalancear.presentation.events.WalletAssetScreenEvents
import com.example.rebalancear.presentation.screen.wallet.components.AddWalletAssetDialog
import com.example.rebalancear.presentation.screen.wallet.components.TopbarContent
import com.example.rebalancear.presentation.screen.wallet.components.WalletAssetCardsContent
import com.example.rebalancear.presentation.states.PageState
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors
import com.example.rebalancear.presentation.viewmodels.WalletViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun WalletScreenComponent(
    navController: NavController,
    walletViewModel: WalletViewModel,
) {

    val navigationEvent = walletViewModel.navigationEvent
    WalletScreenNavigationComponent(navController, navigationEvent)

    val walletState = walletViewModel.walletState

    var enableAddCardDialog by remember { mutableStateOf(false) }


    when (walletState.state) {
        is PageState.Error -> {}
        is PageState.Loading -> {}
        is PageState.Success -> {
            Box() {
                Scaffold(
                    content = { innerPadding ->
                        WalletAssetCardsContent(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .background(RebalanceColors.whiteColor)
                                .padding(10.dp),
                            walletAssets = walletState.state.data.assets,
                            onClickCard = { code ->
                                walletViewModel.onTriggerEvent(
                                    WalletAssetScreenEvents.OnClickAsset(code)
                                )
                            },
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { enableAddCardDialog = true },
                            containerColor = RebalanceColors.primaryColor,
                            contentColor = RebalanceColors.whiteColor,
                            shape = RoundedCornerShape(16.dp)
                        ){
                            Icon(Icons.Filled.Add,"")
                        }
                    }
                )

                AddWalletAssetDialog(
                    enable = enableAddCardDialog,
                    onAdd = { code, units, goal ->
                        walletViewModel.onTriggerEvent(
                            WalletAssetScreenEvents.OnAddWalletAsset(
                                code = code,
                                units = units,
                                goal = goal
                            )
                        )
                        enableAddCardDialog = false
                    },
                    onCancel = { enableAddCardDialog = false }
                )
            }
        }
        is PageState.Undefined -> {}
    }
}


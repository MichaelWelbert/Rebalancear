package com.example.rebalancear.presentation.screen.wallet


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rebalancear.presentation.events.WalletAssetPageEvent
import com.example.rebalancear.presentation.events.WalletAssetScreenEvents
import com.example.rebalancear.presentation.screen.tip.SimpleToolDownArrowtip
import com.example.rebalancear.presentation.screen.wallet.components.AddWalletAssetDialog
import com.example.rebalancear.presentation.screen.wallet.components.WalletAssetCardsContent
import com.example.rebalancear.presentation.states.PageState
import com.example.rebalancear.presentation.ui.theme.RebalanceColors
import com.example.rebalancear.presentation.viewmodels.WalletViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.time.Duration.Companion.seconds


@Composable
internal fun WalletScreenComponent(
    navController: NavController,
    walletViewModel: WalletViewModel,
) {

    val navigationEvent = walletViewModel.navigationEvent
    WalletScreenNavigationComponent(navController, navigationEvent)

    val pageEvent = walletViewModel.alletAssetPageEvent

    val walletState = walletViewModel.walletState

    var toolTipVisible by remember { mutableStateOf(false) }

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
                        FloatingButtonWithToolTip(
                            toolTipVisible = toolTipVisible,
                            onClickFloatingButton = { enableAddCardDialog = true }
                        )
                    },
                    snackbarHost = {

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
                    },
                    onCancel = { enableAddCardDialog = false }
                )
            }
        }
        is PageState.Undefined -> {}
    }

    LaunchedEffect(walletState.state) {
        when (walletState.state) {
            is PageState.Success -> {
                delay(1.0.seconds)
                toolTipVisible = walletState.state.data.assets.isEmpty() && !enableAddCardDialog
            }
            else -> Unit
        }
    }

    LaunchedEffect(enableAddCardDialog) {
        when (walletState.state) {
            is PageState.Success -> {
                delay(1.0.seconds)
                toolTipVisible = !enableAddCardDialog && walletState.state.data.assets.isEmpty()
            }
            else -> Unit
        }
    }

    LaunchedEffect(key1 = Unit) {
        pageEvent.onEach { pageEvent ->
            when (pageEvent) {
                WalletAssetPageEvent.OnAddNewAsset -> enableAddCardDialog = false
            }

        }.launchIn(this)
    }

}

@Composable
private fun FloatingButtonWithToolTip(
    toolTipVisible: Boolean,
    onClickFloatingButton: () -> Unit,
) {

    Column(
        horizontalAlignment = Alignment.End
    ) {

        SimpleToolDownArrowtip(
            visibility = toolTipVisible,
            modifier = Modifier
                .width(220.dp)
                .padding(end = 12.dp, bottom = 4.dp),
            title = "Vamos começar?",
            subtitle = "Adicione seu primeiro ativo clicando aqui!"
        )

        FloatingActionButton(
            onClick = onClickFloatingButton,
            backgroundColor = RebalanceColors.primaryColor,
            contentColor = RebalanceColors.whiteColor,
            shape = RoundedCornerShape(16.dp)
        ) {
            Icon(Icons.Filled.Add, "")
        }
    }
}


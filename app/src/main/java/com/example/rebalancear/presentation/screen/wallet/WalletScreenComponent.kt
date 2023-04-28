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
import com.example.rebalancear.presentation.events.WalletAssetScreenEvents
import com.example.rebalancear.presentation.screen.error.ErrorPageComponent
import com.example.rebalancear.presentation.screen.tip.SimpleToolDownArrowtip
import com.example.rebalancear.presentation.screen.wallet.components.AddWalletAssetDialog
import com.example.rebalancear.presentation.screen.wallet.components.WalletAssetCardsContent
import com.example.rebalancear.presentation.states.base.RequestState
import com.example.rebalancear.presentation.states.base.VisibleState
import com.example.rebalancear.presentation.ui.theme.RebalanceColors
import com.example.rebalancear.presentation.viewmodels.WalletViewModel
import kotlinx.coroutines.delay
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

    val addAssetState = walletViewModel.addAssetState

    var toolTipVisible by remember { mutableStateOf(false) }


    when (walletState.state) {
        is RequestState.Error -> {
            val error = walletState.state.resultError
            ErrorPageComponent(message = error.message)
        }
        is RequestState.Loading -> {}
        is RequestState.Success -> {
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
                            onClickFloatingButton = {
                                walletViewModel.onTriggerEvent(
                                    WalletAssetScreenEvents.OnClickAddAssetButton
                                )
                            }
                        )
                    },
                    snackbarHost = {

                    }
                )

                AddWalletAssetDialog(
                    addAssetState = addAssetState,
                    onAdd = { code, units, goal ->
                        walletViewModel.onTriggerEvent(
                            WalletAssetScreenEvents.OnAddWalletAsset(
                                code = code,
                                units = units,
                                goal = goal
                            )
                        )
                    },
                    onCancel = {
                        walletViewModel.onTriggerEvent(
                            WalletAssetScreenEvents.OnClickToDismissAddAssetButton
                        )
                    }
                )
            }
        }
        is RequestState.Undefined -> {}
    }

    LaunchedEffect(addAssetState.visibility, walletState.state) {
        when (walletState.state) {
            is RequestState.Success -> {
                toolTipVisible = when (addAssetState.visibility) {
                    is VisibleState.Hide -> {
                        delay(1.0.seconds)
                        walletState.state.data.assets.isEmpty()
                    }
                    is VisibleState.Show -> {
                        false
                    }
                }
            }
            else -> Unit
        }
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


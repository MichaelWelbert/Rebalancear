package com.example.app.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app.presentation.events.WalletEvent
import com.example.app.presentation.presenter.AddAssetPresenter
import com.example.app.presentation.presenter.AssetPresenter
import com.example.app.presentation.states.AddAssetState
import com.example.app.presentation.theme.Colors
import com.example.app.presentation.ui.components.assets.WalletAssetCardList
import com.example.app.presentation.ui.components.dialog.InsertAssetDialog
import com.example.app.presentation.ui.components.floating.FloatButton
import com.example.app.presentation.ui.components.header.Header
import com.example.rebalancear.routes.Routes

@Composable
internal fun WalletScreen(
    navController: NavController,
    wallet: List<AssetPresenter>,
    addAssetState: AddAssetState = AddAssetState.Hide,
    onEvent: (WalletEvent) -> Unit,
) {

    Box {
        Scaffold(
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Colors.blackColor)
                        .padding(innerPadding)
                ) {
                    Header()
                    Spacer(modifier = Modifier.height(16.dp))
                    WalletAssetCardList(
                        wallet = wallet,
                        onClickCard = { code ->
                            navController.navigate(Routes.AssetScreen.route + "/${code}")
                        })
                }
                if (addAssetState != AddAssetState.Hide) {
                    InsertAssetDialog(
                        state = addAssetState,
                        onChangeState = {
                            onEvent(WalletEvent.OnChangeAddAssetState(it))
                        },
                        onCancel = {
                            onEvent(
                                WalletEvent.OnChangeAddAssetState(AddAssetState.Hide)
                            )
                        },
                        onConfirm = {
                            onEvent(
                                WalletEvent.OnAddWalletAsset(
                                    code = it.code,
                                    units = it.units,
                                    goal = it.goal
                                )
                            )
                        }
                    )
                }
            },
            floatingActionButton = {
                if (addAssetState == AddAssetState.Hide) {
                    FloatButton(
                        toolTipVisible = false,
                        onClickFloatingButton = {
                            onEvent(
                                WalletEvent.OnChangeAddAssetState(
                                    AddAssetState.InsertAsset(
                                        AddAssetPresenter()
                                    )
                                )
                            )
                        },
                        backgroundColor = Colors.pinkColor,
                        icon = Icons.Filled.Add,
                        iconColor = Colors.whiteColor
                    )
                }
            },
            snackbarHost = {

            }
        )
    }
}

@Preview()
@Composable
private fun WalletScreenPreview() {
    val navController = rememberNavController()
    val wallet = listOf(
        AssetPresenter("BBAS3", 1f, 20f, 20f, 0.5f, 0.2f),
        AssetPresenter("ITSA4", 1f, 50f, 50f, 0.2f, 0.5f),
        AssetPresenter("BBSE4", 1f, 30f, 30f, 0.3f, 0.3f),

        )
    WalletScreen(
        navController, wallet, AddAssetState.InsertAsset(
            AddAssetPresenter()
        )
    ) {}
}
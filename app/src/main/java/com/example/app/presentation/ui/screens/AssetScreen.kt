package com.example.app.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app.core.strings.Format
import com.example.app.presentation.events.AssetEvent
import com.example.app.presentation.presenter.AssetPresenter
import com.example.app.presentation.theme.Colors
import com.example.app.presentation.ui.components.assets.AssetInfo
import com.example.app.presentation.ui.components.assets.AssetPriceTip
import com.example.app.presentation.ui.components.floating.FloatButton
import com.example.app.presentation.ui.components.header.AssetHeader

@Composable
internal fun AssetScreen(
    navController: NavController,
    asset: AssetPresenter,
    onEvent: (AssetEvent) -> Unit,
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
                    AssetHeader(asset.code)
                    AssetPriceTip(
                        unitsGoal = asset.unitsGoal,
                        price = asset.unitPrice
                    )
                    AssetInfo(
                        percentGoal = asset.goal,
                        percentOwned = asset.owned,
                        units = asset.units,
                        investedAmount = (asset.units * asset.unitPrice)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                }
            },
            floatingActionButton = {
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    FloatButton(
                        toolTipVisible = false,
                        onClickFloatingButton = {

                        },
                        backgroundColor = Colors.pinkColor,
                        icon = Icons.Filled.Edit,
                        iconColor = Colors.whiteColor
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    FloatButton(
                        toolTipVisible = false,
                        onClickFloatingButton = {
                            onEvent(AssetEvent.OnDeleteAsset)
                        },
                        backgroundColor = Colors.lightBlackColor,
                        icon = Icons.Filled.Delete,
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
private fun AssetScreenPreview() {
    val navController = rememberNavController()
    val asset = AssetPresenter("BBAS3", 5f, 20f, 20f, 0.5f, 0.25f)
    AssetScreen(navController, asset) {}
}
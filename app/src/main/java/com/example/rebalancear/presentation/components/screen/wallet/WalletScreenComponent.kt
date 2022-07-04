package com.example.rebalancear.presentation.components.screen.wallet

import com.example.rebalancear.R
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rebalancear.routes.Routes
import com.example.rebalancear.ui.theme.RebalanceColors
import com.example.rebalancear.presentation.components.screen.wallet.components.assetCard.AssetCardComponent
import com.example.rebalancear.presentation.components.screen.wallet.components.userResume.UserResumeComponent
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.presentation.viewmodels.WalletViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WalletScreenComponent(
    navController: NavController,
    walletViewModel: WalletViewModel,
) {
    val patrimony = walletViewModel.getPatrimony()

    val walletState = remember {
        walletViewModel.walletState
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Routes.AddAssetScreen.route)
                },
                backgroundColor = RebalanceColors.darkGrey,
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = null,
                        tint = RebalanceColors.white
                    )
                }
            )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)

                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                RebalanceColors.darkGrey,
                                RebalanceColors.lightGrey,
                            ),
                        )
                    ),
            ) {
                Column {
                    UserResumeComponent(patrimony)

                    LazyColumn {
                        items(walletState.assets) { asset ->
                            AssetCardComponent(
                                navController = navController,
                                asset = WalletAssetPresenter(
                                    code = asset.code,
                                    assetType = asset.assetType,
                                    investedAmount = asset.investedAmount,
                                    percentageGoal = asset.percentageGoal,
                                    percentageOwned = asset.percentageOwned,
                                    contributeState = asset.contributeState
                                )
                            )

                            if (walletState.assets.last() == asset) {
                                Spacer(modifier = Modifier.height(32.dp))
                            }
                        }

                    }


                }
            }
        }
    )


}
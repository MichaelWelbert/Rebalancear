package com.example.rebalancear.presentation.components.screen.wallet

import android.annotation.SuppressLint
import android.icu.text.NumberFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rebalancear.presentation.components.screen.wallet.components.assetCard.AddNewCardComponent
import com.example.rebalancear.ui.theme.RebalanceColors
import com.example.rebalancear.presentation.components.screen.wallet.components.assetCard.AssetCardComponent
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.presentation.viewmodels.WalletViewModel
import com.example.rebalancear.ui.theme.ReBalanceTypography


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
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f),
                            text = "Balancear",
                            color = RebalanceColors.white,
                            style = ReBalanceTypography.Tittle,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f)
                                .padding(end = 20.dp),
                            text = "R$${NumberFormat.getInstance().format(patrimony)}",
                            color = RebalanceColors.white,
                            style = ReBalanceTypography.Tittle.copy(fontSize = 16.sp),
                            textAlign = TextAlign.End
                        )
                    }
                },

                backgroundColor = RebalanceColors.darkGrey,
                elevation = 10.dp
            )
        },

        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(RebalanceColors.darkGrey),
            ) {
                Column {
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
                        }
                        item() {
                            AddNewCardComponent(navController = navController)
                            Spacer(modifier = Modifier.height(32.dp))
                        }
                    }
                }
            }
        }
    )


}
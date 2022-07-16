package com.example.rebalancear.presentation.components.screen.wallet.components.assetCard


import android.icu.text.NumberFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rebalancear.R
import com.example.rebalancear.core.AssetTypes
import com.example.rebalancear.core.ContributeState
import com.example.rebalancear.core.RebalanceStrings
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.routes.Routes


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AssetCardComponent(
    navController: NavController,
    asset: WalletAssetPresenter
) {
    val colorList = getColors(asset.contributeState)
    val color0 = colorList[0]
    val color100 = colorList[1]
    val color200 = colorList[2]
    val color300 = colorList[3]
    val color500 = colorList[5]

    BoxWithConstraints(
        modifier = Modifier.clickable {
            navController.navigate(Routes.AssetScreen.route + "/${asset.code}")
        }
    ) {
        val boxWidth = this.maxWidth

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp,
                    end = 16.dp,
                    start = 16.dp,
                ),
        ) {
            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .width(10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 40.dp, bottomStart = 20.dp, bottomEnd = 35.dp, topEnd = 20.dp))
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                color200,
                                color100,
                            )
                        )
                    )
                    .padding(top = 36.dp, bottom = 36.dp, start = 28.dp, end = 28.dp),

                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        modifier = Modifier,
                        text = "R$${NumberFormat.getInstance().format(asset.investedAmount)}",
                        color = color500,
                        style = ReBalanceTypography.Strong5,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        modifier = Modifier,
                        text = RebalanceStrings.wallet_asset_invested_amount,
                        color = color500,
                        style = ReBalanceTypography.Strong1,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = "${NumberFormat.getInstance().format(asset.percentageGoal)}%",
                        color = color500,
                        style = ReBalanceTypography.Strong5,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = RebalanceStrings.wallet_asset_percentage_goal,
                        color = color500,
                        style = ReBalanceTypography.Strong1,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                ) {
                    Text(
                        text = "${NumberFormat.getInstance().format(asset.percentageOwned)}%",
                        color = color500,
                        style = ReBalanceTypography.Strong5,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = RebalanceStrings.wallet_asset_percentage_owned,
                        color = color500,
                        style = ReBalanceTypography.Strong1,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                }


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.width(70.dp))
                }
            }


        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .padding(
                    top = 40.dp,
                    end = 32.dp,
                    start = 24.dp,
                )
        ) {
            Icon(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.BottomEnd),
                painter = painterResource(id = getiCONStatus(asset.contributeState)),
                contentDescription = null,
                tint = color200
            )
        }

        Box(
            modifier = Modifier
                .width((boxWidth.value * 0.4).dp)
                .align(Alignment.TopStart)
                .padding(
                    top = 16.dp,
                    end = 16.dp,
                    start = 24.dp,
                )
                .clip(RoundedCornerShape(topStart = 60.dp, bottomStart = 2.dp, bottomEnd = 80.dp, topEnd = 80.dp))

                .background(color300)

        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                text = asset.code,
                color = color0,
                style = ReBalanceTypography.Strong3,
                textAlign = TextAlign.Center
            )
        }
    }
}


private fun getColors(status: ContributeState): List<Color> {
    return when (status) {
        ContributeState.CONTRIBUTE -> {
            listOf(
                RebalanceColors.green0,
                RebalanceColors.green100,
                RebalanceColors.green200,
                RebalanceColors.green300,
                RebalanceColors.green400,
                RebalanceColors.green500,
            )
        }
        ContributeState.WAIT -> {
            listOf(
                RebalanceColors.orange0,
                RebalanceColors.orange100,
                RebalanceColors.orange200,
                RebalanceColors.orange300,
                RebalanceColors.orange400,
                RebalanceColors.orange500,
            )
        }
    }
}

private fun getiCONStatus(status: ContributeState): Int {
    return when (status) {
        ContributeState.CONTRIBUTE -> R.drawable.ic_comprar
        ContributeState.WAIT -> R.drawable.ic_esperar
    }
}

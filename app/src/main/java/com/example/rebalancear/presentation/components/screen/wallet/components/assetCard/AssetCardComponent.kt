package com.example.rebalancear.presentation.components.screen.wallet.components.assetCard


import android.icu.text.NumberFormat
import androidx.compose.foundation.BorderStroke
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
import com.example.rebalancear.core.ContributeState
import com.example.rebalancear.core.RebalanceStrings
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.routes.Routes


@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AssetCardComponent(
    navController: NavController,
    asset: WalletAssetPresenter
) {
    val colorList = getColors(asset.contributeState)
    val color200 = colorList[2]
    val color400 = colorList[4]


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
                    .clip(RoundedCornerShape(20))
                    .background(color200)
                    .padding(
                        top = 40.dp,
                        bottom = 28.dp,
                        start = 28.dp,
                        end = 28.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        modifier = Modifier,
                        text = "R$${NumberFormat.getInstance().format(asset.investedAmount)}",
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong5,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        modifier = Modifier,
                        text = RebalanceStrings.wallet_asset_invested_amount,
                        color = RebalanceColors.white,
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
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong5,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = RebalanceStrings.wallet_asset_percentage_goal,
                        color = RebalanceColors.white,
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
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong5,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = RebalanceStrings.wallet_asset_percentage_owned,
                        color = RebalanceColors.white,
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
                    Text(
                        text = getStatus(asset.contributeState),
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong5,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                }
            }


        }

        /*
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .padding(
                    top = 37.dp,
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
                tint = color400
            )
        }


         */
        Box(
            modifier = Modifier
                .width((boxWidth.value * 0.4).dp)
                .align(Alignment.TopStart)
                .padding(
                    top = 16.dp,
                    end = 16.dp,
                    start = 16.dp,
                )
                .clip(RoundedCornerShape(topStart = 60.dp, bottomStart = 2.dp, bottomEnd = 80.dp, topEnd = 80.dp))

                .background(color400)

        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                text = asset.code,
                color = Color.White,
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
                RebalanceColors.red0,
                RebalanceColors.red100,
                RebalanceColors.red200,
                RebalanceColors.red300,
                RebalanceColors.red400,
                RebalanceColors.red500,
            )
        }
    }
}

private fun getStatus(status: ContributeState): String {
    return when (status) {
        ContributeState.CONTRIBUTE -> "Comprar"
        ContributeState.WAIT -> "Esperar"
    }
}

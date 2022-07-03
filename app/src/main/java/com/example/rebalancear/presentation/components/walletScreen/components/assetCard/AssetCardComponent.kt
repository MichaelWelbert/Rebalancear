package com.example.rebalancear.presentation.components.walletScreen.components.assetCard


import android.icu.text.NumberFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rebalancear.core.AssetTypes
import com.example.rebalancear.core.ContributeState
import com.example.rebalancear.ui.RebalanceStrings
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter


@Composable
fun AssetCardComponent(
    asset: WalletAssetPresenter
) {
    androidx.compose.material.Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                end = 16.dp,
                start = 16.dp,
                bottom = 4.dp
            ),
        elevation = 2.dp,
        shape = RoundedCornerShape(12),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        colors = getColorsStatus(asset.contributeState),
                    )
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 24.dp)
                    .fillMaxWidth()
                    .weight(0.6f)
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    text = asset.code,
                    color = RebalanceColors.white,
                    style = ReBalanceTypography.Strong5,
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "${RebalanceStrings.wallet_asset_type}: ${getTypeText(asset.assetType)}",
                    color = RebalanceColors.white,
                    style = ReBalanceTypography.Body1.copy(fontWeight = FontWeight(800), fontSize = 8.sp),
                )

                Row(
                    modifier = Modifier.padding(
                        top = 12.dp,
                        bottom = 12.dp,
                        start = 4.dp
                    ),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5f, true),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "R$ ${NumberFormat.getInstance().format(asset.investedAmount)}",
                            color = RebalanceColors.white,
                            style = ReBalanceTypography.Strong3,
                        )
                        Text(
                            modifier = Modifier,
                            text = RebalanceStrings.wallet_asset_invested_amount,
                            color = RebalanceColors.white,
                            style = ReBalanceTypography.Strong1,
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.25f, true),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "${NumberFormat.getInstance().format(asset.percentageOwned)}%",
                            color = RebalanceColors.white,
                            style = ReBalanceTypography.Strong3,
                        )
                        Text(
                            modifier = Modifier,
                            text = RebalanceStrings.wallet_asset_percentage_owned,
                            color = RebalanceColors.white,
                            style = ReBalanceTypography.Strong1,
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.25f, true)
                            .padding(
                                start = 12.dp
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "${NumberFormat.getInstance().format(asset.percentageGoal)}%",
                            color = RebalanceColors.white,
                            style = ReBalanceTypography.Strong3,
                        )
                        Text(
                            modifier = Modifier,
                            text = RebalanceStrings.wallet_asset_percentage_goal,
                            color = RebalanceColors.white,
                            style = ReBalanceTypography.Strong1,
                        )
                    }

                }
            }
            Column(
                modifier = Modifier
                    .padding(start = 24.dp, end = 12.dp)
                    .weight(0.4f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Column {
                    Text(
                        modifier = Modifier,
                        text = getTextStatus(asset.contributeState),
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong5,
                    )
                }
            }
        }
    }


}


private fun getColorsStatus(status: ContributeState): List<Color> {
    return when (status) {
        ContributeState.CONTRIBUTE -> {
            listOf(
                RebalanceColors.darkOceanBlue,
                RebalanceColors.lightOceanBlue,
            )
        }
        ContributeState.WAIT -> {
            listOf(
                RebalanceColors.darkRed,
                RebalanceColors.lightRed,
            )
        }
    }
}

private fun getTextStatus(status: ContributeState): String {
    return when (status) {
        ContributeState.CONTRIBUTE -> RebalanceStrings.wallet_asset_status_contribute
        ContributeState.WAIT -> RebalanceStrings.wallet_asset_status_wait
    }
}

private fun getTypeText(type: AssetTypes): String {
    return when (type) {
        AssetTypes.STOCKS -> RebalanceStrings.wallet_asset_type_STOCKS
        AssetTypes.FIIS -> RebalanceStrings.wallet_asset_type_FIIS
        AssetTypes.BONDS -> RebalanceStrings.wallet_asset_type_BONDS
        AssetTypes.CRYPTO -> RebalanceStrings.wallet_asset_type_CRYPTO
    }
}
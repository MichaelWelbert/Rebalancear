package com.example.rebalancear.presentation.screen.wallet.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.rebalancear.core.strings.WalletScreenStrings
import com.example.rebalancear.domain.status.ContributeStatus
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WalletAssetCard(
    onClickCard: (code: String) -> Unit,
    asset: WalletAssetPresenter
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
            .zIndex(5f)
            .clickable {
                onClickCard(asset.code)
            },

        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(RebalanceColors.whiteColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)

    ) {
        CardContent(asset)
    }
}

@Composable
private fun CardContent(asset: WalletAssetPresenter) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, top = 12.dp, bottom = 24.dp)
                .weight(1f, false),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier,
                    text = asset.code,
                    color = RebalanceColors.secondaryColor,
                    style = ReBalanceTypography.Strong3.copy(
                        fontSize = 16.sp,
                        letterSpacing = 1.2.sp
                    ),
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    modifier = Modifier,
                    text = "R$ ${String.format("%.2f", asset.investedAmount)}",
                    color = RebalanceColors.blackColor,
                    style = ReBalanceTypography.Strong3,
                )
                Text(
                    modifier = Modifier,
                    text = WalletScreenStrings.wallet_asset_invested_amount,
                    color = RebalanceColors.greyColor,
                    style = ReBalanceTypography.Strong2.copy(letterSpacing = 1.2.sp),
                )
            }

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    modifier = Modifier,
                    text = "${String.format("%.1f", asset.percentOwned)}%",
                    color = RebalanceColors.blackColor,
                    style = ReBalanceTypography.Strong3,
                )
                Text(
                    modifier = Modifier,
                    text = WalletScreenStrings.wallet_asset_percentage_owned,
                    color = RebalanceColors.greyColor,
                    style = ReBalanceTypography.Strong2.copy(letterSpacing = 1.2.sp),
                )
            }

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    modifier = Modifier,
                    text = "${String.format("%.1f", asset.percentGoal)}%",
                    color = RebalanceColors.blackColor,
                    style = ReBalanceTypography.Strong3,
                )
                Text(
                    modifier = Modifier,
                    text = WalletScreenStrings.wallet_asset_percentage_goal,
                    color = RebalanceColors.greyColor,
                    style = ReBalanceTypography.Strong2.copy(letterSpacing = 1.2.sp),
                )
            }


        }

        Row(
            modifier = Modifier.padding(start = 28.dp, end = 28.dp, top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier,
                text = getStatus(asset.contributeState).uppercase(),
                color = getColors(asset.contributeState),
                style = ReBalanceTypography.Strong3,
                textAlign = TextAlign.Center
            )
        }
    }
}


private fun getColors(status: ContributeStatus): Color {
    return when (status) {
        ContributeStatus.CONTRIBUTE -> RebalanceColors.rightColor
        ContributeStatus.WAIT -> RebalanceColors.wrongColor
    }
}

private fun getStatus(status: ContributeStatus): String {
    return when (status) {
        ContributeStatus.CONTRIBUTE -> WalletScreenStrings.wallet_asset_status_contribute
        ContributeStatus.WAIT -> WalletScreenStrings.wallet_asset_status_wait
    }
}

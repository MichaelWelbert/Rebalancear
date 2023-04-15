package com.example.rebalancear.presentation.screen.wallet.components


import androidx.compose.foundation.BorderStroke
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
import androidx.navigation.NavController
import com.example.rebalancear.core.strings.WalletScreenStrings
import com.example.rebalancear.domain.status.ContributeStatus
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.routes.Routes
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WalletAssetCard(
    onClickCard : (code: String) -> Unit,
    asset: WalletAssetPresenter
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .clickable {
               onClickCard(asset.code)
            },

        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(RebalanceColors.neutral400),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)

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
                .padding(start = 32.dp, end = 32.dp, top = 12.dp, bottom = 24.dp)
                .weight(1f,false),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {

            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier,
                    text = asset.code,
                    color = RebalanceColors.yellow100,
                    style = ReBalanceTypography.Strong3,
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    modifier = Modifier,
                    text = "R$ ${String.format("%.2f", asset.investedAmount)}",
                    color = RebalanceColors.neutral100,
                    style = ReBalanceTypography.Strong3,
                )
                Text(
                    modifier = Modifier,
                    text = WalletScreenStrings.wallet_asset_invested_amount,
                    color = RebalanceColors.neutral200,
                    style = ReBalanceTypography.Strong2,
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
                    color = RebalanceColors.neutral100,
                    style = ReBalanceTypography.Strong3,
                )
                Text(
                    modifier = Modifier,
                    text = WalletScreenStrings.wallet_asset_percentage_goal,
                    color = RebalanceColors.neutral200,
                    style = ReBalanceTypography.Strong2,
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
                    color = RebalanceColors.neutral100,
                    style = ReBalanceTypography.Strong3,
                )
                Text(
                    modifier = Modifier,
                    text = WalletScreenStrings.wallet_asset_percentage_owned,
                    color = RebalanceColors.neutral200,
                    style = ReBalanceTypography.Strong2,
                )
            }
        }

        Row(
            modifier = Modifier.padding(end = 32.dp, top = 8.dp),
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
        ContributeStatus.CONTRIBUTE -> RebalanceColors.green100
        ContributeStatus.WAIT -> RebalanceColors.red100
    }
}

private fun getStatus(status: ContributeStatus): String {
    return when (status) {
        ContributeStatus.CONTRIBUTE ->WalletScreenStrings.wallet_asset_status_contribute
        ContributeStatus.WAIT -> WalletScreenStrings.wallet_asset_status_wait
    }
}

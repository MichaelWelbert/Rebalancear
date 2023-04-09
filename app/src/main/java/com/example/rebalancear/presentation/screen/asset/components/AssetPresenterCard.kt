package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.rebalancear.domain.status.ContributeStatus
import com.example.rebalancear.presentation.presenters.AssetPresenter
import com.example.rebalancear.ui.theme.RebalanceColors

@Composable
internal fun AssetPresenterCard(
    modifier: Modifier = Modifier,
    asset: AssetPresenter
) {
    val statusColor200 = getColors200(asset.contributeState)
    val statusColor100 = getColors100(asset.contributeState)

    LazyColumn(modifier = modifier) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(
                        1.dp, RebalanceColors.neutral300,
                        RoundedCornerShape(20.dp)
                    )
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                AssetPresenterCardHeader(
                    percentGoal = asset.percentGoal,
                    percentOwned = asset.percentOwned,
                    statusColor = statusColor200
                )

                Spacer(modifier = Modifier.height(32.dp))

                AssetPresenterCardInfos(
                    modifier.padding(horizontal = 24.dp),
                    asset = asset
                )

                Spacer(modifier = Modifier.height(16.dp))

                AssetPresenterInvestmentTip(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    asset = asset,
                    statusColor = statusColor100
                )

                Spacer(modifier = Modifier.height(20.dp))

                AssetPresenterCardUpdateButton(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    text = "Atualizar unidades",
                    statusColor = statusColor200
                )

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

private fun getColors100(status: ContributeStatus): Color {
    return when (status) {
        ContributeStatus.CONTRIBUTE -> RebalanceColors.green100
        ContributeStatus.WAIT -> RebalanceColors.red100
    }
}

private fun getColors200(status: ContributeStatus): Color {
    return when (status) {
        ContributeStatus.CONTRIBUTE -> RebalanceColors.green200
        ContributeStatus.WAIT -> RebalanceColors.red200
    }
}

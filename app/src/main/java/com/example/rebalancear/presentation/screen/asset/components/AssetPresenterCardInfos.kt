package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rebalancear.core.strings.AssetScreenStrings
import com.example.rebalancear.presentation.presenters.AssetPresenter
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

@Composable
internal fun AssetPresenterCardInfos (
    modifier: Modifier = Modifier,
    asset: AssetPresenter
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        AssetPresenterCardInfo(
            title = AssetScreenStrings.asset_info_price,
            description = String.format("R$ %.2f", asset.unitPrice),
            color = RebalanceColors.neutral200
        )

        Spacer(modifier = Modifier.height(4.dp))

        AssetPresenterCardInfo(
            title = AssetScreenStrings.asset_info_have,
            description = String.format("%.0f", asset.units),
            color = RebalanceColors.neutral200
        )

        Spacer(modifier = Modifier.height(4.dp))

        AssetPresenterCardInfo(
            title = AssetScreenStrings.asset_info_percent,
            description = String.format("%.0f", asset.unitsGoal),
            color = RebalanceColors.neutral0
        )

        Spacer(modifier = Modifier.height(4.dp))

        AssetPresenterCardInfo(
            title = AssetScreenStrings.asset_info_total_invested,
            description = String.format("R$ %.2f", asset.investedAmount),
            color = RebalanceColors.neutral200
        )

        Spacer(modifier = Modifier.height(4.dp))

        AssetPresenterCardInfo(
            title = AssetScreenStrings.asset_info_total_goal,
            description = String.format("R$ %.2f", asset.investedAmountGoal),
            color = RebalanceColors.neutral0
        )
    }
}
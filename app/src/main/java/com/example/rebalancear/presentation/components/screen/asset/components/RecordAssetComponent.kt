package com.example.rebalancear.presentation.components.screen.asset.components

import android.icu.text.NumberFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rebalancear.R
import com.example.rebalancear.core.RecordType
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.core.RebalanceStrings
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RecordAssetComponent(
    asset: WalletAssetPresenter,
    recordType: RecordType
) {
    androidx.compose.material.Card(
        modifier = Modifier
            .fillMaxWidth() .padding(horizontal = 12.dp),
        elevation = 3.dp,
        shape = RoundedCornerShape(28),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(brush = Brush.linearGradient(colors = listOf(
                    RebalanceColors.neutral300,
                    RebalanceColors.neutral300,
                ))),

            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth().padding(horizontal = 16.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    modifier = Modifier.padding(start = 8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        modifier = Modifier,
                        text = "R$ ${NumberFormat.getInstance().format(asset.investedAmount)}",
                        color =  RebalanceColors.neutral100,
                        style = ReBalanceTypography.Strong2,
                    )
                    Text(
                        modifier = Modifier,
                        text = getTextStatus(recordType),
                        color = getColorsStatus(recordType),
                        style = ReBalanceTypography.Strong1,
                    )
                }

                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier,
                        text = "25",
                        color =  RebalanceColors.neutral100,
                        style = ReBalanceTypography.Strong2,
                    )
                    Text(
                        modifier = Modifier,
                        text = RebalanceStrings.asset_record_unit,
                        color = RebalanceColors.neutral0,
                        style = ReBalanceTypography.Strong1,
                    )
                }

                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier,
                        text = "R$34,20",
                        color = RebalanceColors.neutral100,
                        style = ReBalanceTypography.Strong2,
                    )
                    Text(
                        modifier = Modifier,
                        text =  RebalanceStrings.asset_record_value,
                        color = RebalanceColors.neutral0,
                        style = ReBalanceTypography.Strong1,
                    )
                }

                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .shadow(elevation = 2.dp, RoundedCornerShape(20.dp))
                        .background(color = RebalanceColors.red200)
                        .clickable {

                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.ic_delete),
                        contentDescription = null,
                        tint = RebalanceColors.red100
                    )
                }
            }
        }
    }
}

private fun getColorsStatus(type: RecordType): Color {
    return when (type) {
        RecordType.BUY -> RebalanceColors.green100
        RecordType.SELL -> RebalanceColors.red100
    }
}

private fun getTextStatus(type: RecordType): String {
    return when (type) {
        RecordType.BUY -> RebalanceStrings.asset_record_invested_amount
        RecordType.SELL -> RebalanceStrings.asset_record_sold_amount
    }
}


private fun getTextActionStatus(type: RecordType): String {
    return when (type) {
        RecordType.BUY -> RebalanceStrings.wallet_asset_invested_amount
        RecordType.SELL -> RebalanceStrings.wallet_asset_invested_amount
    }
}
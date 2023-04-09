package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rebalancear.presentation.presenters.AssetPresenter
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

@Composable
internal fun AssetPresenterInvestmentTip(
    modifier: Modifier = Modifier,
    asset: AssetPresenter,
    statusColor: Color,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            text = getAssetAlertMessage(
                percentGoal = asset.percentGoal,
                percentOwned = asset.percentOwned,
                investedAmountGoal = asset.investedAmountGoal,
                investedAmount = asset.investedAmount,
                unitsGoal = asset.unitsGoal,
                units = asset.units,
                statusColor = statusColor
            ),
            color = RebalanceColors.neutral100,
            style = ReBalanceTypography.Strong2.copy(textAlign = TextAlign.Center),
        )
    }
}



private fun getAssetAlertMessage(
    percentGoal: Double,
    percentOwned: Double,
    units: Double,
    unitsGoal: Double,
    investedAmount: Double,
    investedAmountGoal: Double,
    statusColor: Color
): AnnotatedString {

    val percentGap = percentGoal - percentOwned
    val unitGap = unitsGoal - units
    val investedGap = investedAmountGoal - investedAmount


    return if (percentGap < 0) {
        val investedGapText = String.format("%.2f", investedGap * -1)
        val unitGapText = String.format("%.0f", unitGap * -1)
        if (unitGap == 0.0)
            buildAnnotatedString {
                append("Esse ativo está aproximadamente")
                withStyle(style = SpanStyle(color = statusColor, fontSize = 13.sp)) {
                    append(" R$ $investedGapText ")
                }
                append("acima da sua meta!!")
            }
        else
            buildAnnotatedString {
                append("Esse ativo está")
                withStyle(style = SpanStyle(color = statusColor, fontSize = 13.sp)) {
                    append(" $unitGapText ")
                }
                append("unidades acima da sua meta")
                withStyle(style = SpanStyle(color = statusColor, fontSize = 13.sp)) {
                    append(" R$ $investedGapText ")
                }
                append("acima da sua meta!")
            }
    } else if (percentGap > 0) {
        val investedGapText = String.format("%.2f", investedGap)
        val unitGapText = String.format("%.0f", unitGap)
        if (unitGap == 0.0)
            buildAnnotatedString {
                append("É necessário aproximadamente")
                withStyle(style = SpanStyle(color = statusColor, fontSize = 13.sp)) {
                    append(" R$ $investedGapText ")
                }
                append("para atingir a meta!!")
            }
        else
            buildAnnotatedString {
                append("É necessário mais")
                withStyle(style = SpanStyle(color = statusColor, fontSize = 13.sp)) {
                    append(" $unitGapText ")
                }
                append("unidades desse ativo!")
                withStyle(style = SpanStyle(color = statusColor, fontSize = 13.sp)) {
                    append(" R$ $investedGapText ")
                }
                append("para atingir a meta!")
            }
    } else
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = statusColor, fontSize = 13.sp)) {
                append("Uhull, esse ativo está de acordo com a sua meta!!")
            }
        }


}
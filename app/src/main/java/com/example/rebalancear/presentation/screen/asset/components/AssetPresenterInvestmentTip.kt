package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rebalancear.domain.status.ContributeStatus
import com.example.rebalancear.presentation.presenters.AssetPresenter
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors
import kotlin.math.absoluteValue

@Composable
internal fun AssetPresenterInvestmentTip(
    modifier: Modifier = Modifier,
    asset: AssetPresenter,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            text = getMessage(
                currentPrice = asset.unitPrice,
                percentGoal = asset.percentGoal,
                percentOwned = asset.percentOwned,
                investedAmountGoal = asset.investedAmountGoal,
                investedAmount = asset.investedAmount,
                unitsGoal = asset.unitsGoal,
                units = asset.units,
                status = asset.contributeState,
            ),
            color = RebalanceColors.blackColor,
            style = ReBalanceTypography.Body2.copy(textAlign = TextAlign.Justify),
        )
    }
}

@Composable
private fun getMessage(
    currentPrice: Double,
    percentGoal: Double,
    percentOwned: Double,
    units: Double,
    unitsGoal: Double,
    investedAmount: Double,
    investedAmountGoal: Double,
    status: ContributeStatus,
): AnnotatedString {
    val percentGap = percentGoal - percentOwned
    val unitGap = unitsGoal - units
    val investedGap = investedAmountGoal - investedAmount

    return when (status) {
        ContributeStatus.CONTRIBUTE -> {
            unreachGoaltext(
                currentPrice = currentPrice,
                percentGap = percentGap,
                unitGap = unitGap,
                investedGap = investedGap,
            )
        }
        ContributeStatus.WAIT -> {
            reachGoaltext(
                currentPrice = currentPrice,
                percentGap = percentGap,
                unitGap = unitGap,
                investedGap = investedGap,
            )
        }
    }
}


@Composable
private fun unreachGoaltext(
    currentPrice: Double,
    percentGap: Double,
    unitGap: Double,
    investedGap: Double,
): AnnotatedString {

    /*
     "Você está quase lá! Apenas faltam 12% para você alcançar sua meta. Para atingi-la, uma opção seria comprar 9 unidades das ações por R$5 cada, totalizando um gasto de R$32. Dessa forma, você conseguirá atingir seu objetivo."
     */
    val spanStyle = SpanStyle(color = RebalanceColors.rightColor, fontSize = 13.sp, fontWeight = FontWeight.ExtraBold)

    return buildAnnotatedString {
        append("Você está quase lá! Faltam apenas")
        withStyle(style = spanStyle) {
            append(String.format(" %.2f%% ", percentGap.absoluteValue))
        }
        append("para você alcançar sua meta. Para atingi-la, uma opção seria comprar")

        withStyle(style = spanStyle) {
            append(String.format(" %.0f ", unitGap.absoluteValue))
        }

        append("unidades das ações por")

        withStyle(style = spanStyle) {
            append(String.format(" R$ %.2f ", currentPrice.absoluteValue))
        }

        append("cada, totalizando um gasto de")

        withStyle(style = spanStyle) {
            append(String.format(" R$ %.2f. ", investedGap.absoluteValue))
        }

        append("Dessa forma, você conseguirá atingir seu objetivo.")
    }
}


@Composable
private fun reachGoaltext(
    currentPrice: Double,
    percentGap: Double,
    unitGap: Double,
    investedGap: Double,
): AnnotatedString {

    /*
    Parabéns! Você ultrapassou sua meta e está 12% acima do que havia planejado. Atualmente, você possui 9 unidades das ações a R$5 cada unidade, totalizando um acumulo de R$32 acima da meta. No entanto, agora é importante avaliar outras oportunidades de investimento em ações em que você ainda não atingiu seus objetivos. Portanto, sugerimos que não priorize mais essa ação no momento e concentre seus esforços em outras oportunidades.
     */
    val spanStyle = SpanStyle(color = RebalanceColors.wrongColor, fontSize = 13.sp, fontWeight = FontWeight.ExtraBold)

    return buildAnnotatedString {
        append("Parabéns! Você ultrapassou sua meta e está")
        withStyle(style = spanStyle) {
            append(String.format(" %.2f%% ", percentGap.absoluteValue))
        }
        append("acima do que havia planejado. Atualmente, você possui")

        withStyle(style = spanStyle) {
            append(String.format(" %.0f ", unitGap.absoluteValue))
        }

        append("unidades acima da sua meta, no valor de ")

        withStyle(style = spanStyle) {
            append(String.format(" R$ %.2f ", currentPrice.absoluteValue))
        }

        append("cada unidade, totalizando um acumulo de")

        withStyle(style = spanStyle) {
            append(String.format(" R$ %.2f ", investedGap.absoluteValue))
        }

        append("acima do esperado. Agora, é importante avaliar outras oportunidades de investimento em ações em que você ainda não atingiu seus objetivos.")
    }
}
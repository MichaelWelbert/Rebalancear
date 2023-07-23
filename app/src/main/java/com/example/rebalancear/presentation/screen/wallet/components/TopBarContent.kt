package com.example.rebalancear.presentation.screen.wallet.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rebalancear.core.strings.WalletScreenStrings
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

@Composable
internal fun TopbarContent(
    patrimony: Double,
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f),
                    text = WalletScreenStrings.wallet_top_bar_title,
                    color = RebalanceColors.whiteColor,
                    style = ReBalanceTypography.Tittle,
                    textAlign = TextAlign.Start
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f)
                        .padding(end = 20.dp),
                    text ="R$ ${String.format("%.2f",patrimony)}",
                    color = RebalanceColors.whiteColor,
                    style = ReBalanceTypography.Tittle.copy(fontSize = 16.sp),
                    textAlign = TextAlign.End
                )
            }
        },
        backgroundColor = RebalanceColors.whiteColor,
        elevation = 10.dp
    )

}

@Composable
@Preview(showBackground = true)
fun TopbarTest() {
    TopbarContent(patrimony = 2000.00)
}
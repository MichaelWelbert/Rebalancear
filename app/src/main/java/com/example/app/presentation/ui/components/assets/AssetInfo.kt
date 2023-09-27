package com.example.app.presentation.ui.components.assets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.core.strings.Format
import com.example.app.presentation.theme.Colors
import com.example.rebalancear.presentation.ui.theme.style


@Composable
fun AssetInfo(
    percentGoal: Float,
    percentOwned: Float,
    units: Float,
    investedAmount: Float,
) {
    Column(
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "META",
            color = Colors.whiteColor,
            style = style.Body5,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(6.dp))
        Progress(
            percentGoal = percentGoal,
            percentOwned = percentOwned,
            backgroundColor = Colors.whiteColor,
            textGoalColor = Colors.pinkColor
        )
        Spacer(modifier = Modifier.height(24.dp))
        UnitsAndPrice(units.toInt(), investedAmount)
    }
}

@Composable
private fun UnitsAndPrice(units: Int, investedAmount: Float) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            androidx.compose.material.Text(
                text = "Possuo",
                color = Colors.pinkColor,
                style = style.Body5,
                textAlign = TextAlign.Center
            )
            androidx.compose.material.Text(
                text = "$units unidades",
                color = Colors.whiteColor,
                style = style.Body5,
                textAlign = TextAlign.Center
            )
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            androidx.compose.material.Text(

                text = "Investidos",
                color = Colors.pinkColor,
                style = style.Body5,
                textAlign = TextAlign.Center
            )
            androidx.compose.material.Text(
                text = Format.convertFloatToPriceFormat(investedAmount),
                color = Colors.whiteColor,
                style = style.Body5,
                textAlign = TextAlign.Center
            )
        }

    }
}


@Preview
@Composable
fun PreviewAssetInfo() {
    AssetInfo(
        percentGoal = 0.5f,
        percentOwned = 0.2f,
        units = 25.2f,
        investedAmount = 5532.1f
    )
}
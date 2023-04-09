package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

@Composable
internal fun AssetPresenterCardUpdateButton(
    modifier: Modifier = Modifier,
    text: String,
    statusColor: Color,
) {
    Column(
        modifier = modifier.fillMaxWidth()

    ) {
        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 2.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = statusColor
            ),
            shape = RoundedCornerShape(20),

            ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = text,
                color = RebalanceColors.neutral0,
                style = ReBalanceTypography.Strong3.copy(
                    textAlign = TextAlign.Start
                ),
            )
        }
    }
}
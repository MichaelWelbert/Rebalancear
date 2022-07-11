package com.example.rebalancear.presentation.components.shared


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors

@Composable
fun ActionCardComponent(
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    icon: Int,
    colors: List<Color>
) {
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .shadow(2.dp, RoundedCornerShape(20.dp))
            .background(
                Brush.linearGradient(colors = colors),
            )

    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(0.75f)
                    .padding(start = 8.dp)
            ) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title.uppercase(),
                    color = RebalanceColors.white,
                    style = ReBalanceTypography.Strong5.copy(textAlign = TextAlign.Start),
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    text = subtitle,
                    color = RebalanceColors.white,
                    style = ReBalanceTypography.Body2.copy(textAlign = TextAlign.Start),
                )

                Spacer(modifier = Modifier.height(12.dp))
            }

            Box(
                modifier = Modifier.weight(0.25f),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(56.dp)
                        .fillMaxWidth(),
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = RebalanceColors.white.copy(alpha = 0.7f)
                )
            }
        }
    }
}
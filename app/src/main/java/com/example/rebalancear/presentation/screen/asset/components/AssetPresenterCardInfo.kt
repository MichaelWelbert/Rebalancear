package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography

@Composable
internal fun AssetPresenterCardInfo(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    color: Color
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier,
            text = title,
            color = color,
            style = ReBalanceTypography.Strong2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            modifier = Modifier,
            text = description,
            color = color,
            style = ReBalanceTypography.Strong3,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
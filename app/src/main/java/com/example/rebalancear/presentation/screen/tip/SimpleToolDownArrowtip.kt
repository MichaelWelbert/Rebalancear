package com.example.rebalancear.presentation.screen.tip

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rebalancear.R
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

@Composable
fun SimpleToolDownArrowtip(
    modifier: Modifier = Modifier,
    visibility: Boolean,
    title: String,
    subtitle: String,
) {

    AnimatedVisibility(
        visible = visibility,
        enter = fadeIn(
            initialAlpha = 0.4f
        ),
        exit = fadeOut(
            animationSpec = tween(durationMillis = 250)
        )
    ) {
        Column(modifier = modifier) {
            Box(
                modifier = Modifier.background(
                    RebalanceColors.whiteColor,
                    shape = RoundedCornerShape(16.dp)
                ),
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                ) {
                    Text(
                        text = title,
                        color = RebalanceColors.secondaryColor.copy(alpha = 0.85f),
                        style = ReBalanceTypography.Strong2
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = subtitle,
                        color = RebalanceColors.primaryColor.copy(alpha = 0.85f),
                        style = ReBalanceTypography.Body2
                    )
                }
            }
            Icon(
                modifier = Modifier.align(Alignment.End).padding(end = 24.dp),
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = null,
                tint = RebalanceColors.whiteColor
            )
        }

    }

}
package com.example.rebalancear.presentation.screen.tip

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.Colors

@Composable
fun SimpleTooltip(
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

        Box(
            modifier = Modifier.background(
                Colors.blackColor.copy(alpha = 0.85f),
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
                    color = Colors.whiteColor,
                    style = ReBalanceTypography.Strong2
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = subtitle,
                    color = Colors.greyColor,
                    style = ReBalanceTypography.Body2
                )
            }
        }
    }
}
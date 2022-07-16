package com.example.rebalancear.presentation.components.shared

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors

@Composable
fun CircularProgressIndicatorComponent(
    title: String,
    value: String,
    progress: Float
) {
    val progress by remember { mutableStateOf(progress) }
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
        ) {

            CircularProgressIndicator(
                modifier = Modifier.size(50.dp),
                progress = animatedProgress,
                color = RebalanceColors.green300,
                strokeWidth = 3.dp
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center).padding(end = 6.dp)
                    .zIndex(-2f)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = value,
                    color = RebalanceColors.green300,
                    style = ReBalanceTypography.Strong3,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            text = title,
            color = RebalanceColors.green300,
            style = ReBalanceTypography.Strong1,
            textAlign = TextAlign.Start
        )
    }
}
package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rebalancear.domain.status.ContributeStatus
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

@Composable
internal fun AssetProgressIndicator(
    title: String,
    goalValue: String,
    currentValue: String,
    progress: Float,
    contributeStatus: ContributeStatus,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                text = title,
                color = RebalanceColors.blackColor,
                style = ReBalanceTypography.Strong2.copy(letterSpacing = 1.2.sp),
            )

            Text(
                modifier = Modifier,
                text = goalValue,
                color = RebalanceColors.blackColor,
                style = ReBalanceTypography.Strong2.copy(letterSpacing = 1.2.sp),
            )
        }

        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            progress = progress,
            color = when (contributeStatus) {
                ContributeStatus.CONTRIBUTE -> RebalanceColors.rightColor
                ContributeStatus.WAIT -> RebalanceColors.wrongColor
            },
        )

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .requiredWidthIn(min = 42.dp)
                .fillMaxWidth(progress),
            horizontalArrangement = when (contributeStatus) {
                ContributeStatus.CONTRIBUTE -> if (progress < 0.2f)
                    Arrangement.Start else Arrangement.End
                ContributeStatus.WAIT -> Arrangement.Center
            }

        ) {
            Text(
                modifier = Modifier,
                text = currentValue,
                color = RebalanceColors.greyColor,
                style = ReBalanceTypography.Strong1.copy(letterSpacing = 1.2.sp),
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewProgress() {
    AssetProgressIndicator(
        title = "Porcentagem",
        goalValue = "11,4%",
        currentValue = "12,41%",
        progress = 0.5f,
        contributeStatus = ContributeStatus.CONTRIBUTE,
    )
}


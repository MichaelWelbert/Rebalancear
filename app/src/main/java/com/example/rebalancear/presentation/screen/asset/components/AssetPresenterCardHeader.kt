package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.rebalancear.R
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors

@Composable
internal fun AssetPresenterCardHeader(
    modifier: Modifier = Modifier,
    percentGoal : Double,
    percentOwned : Double,
    statusColor : Color
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.Bottom
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                modifier = Modifier
                    .size(50.dp),
                painter = painterResource(id = R.drawable.ic_goal),
                contentDescription = null,
                tint = RebalanceColors.neutral200
            )
            Spacer(modifier = Modifier.width(16.dp))



            Column() {
                Text(
                    modifier = Modifier,
                    text = "MINHA META É DE ${percentGoal}%",
                    color = RebalanceColors.neutral0,
                    style = ReBalanceTypography.Strong3,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    modifier = Modifier,
                    text = "TENHO ATUALMENTE ${percentOwned}%",
                    color = RebalanceColors.neutral200,
                    style = ReBalanceTypography.Strong1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(4.dp))
            }

        }

        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 28.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(color =  statusColor)
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp),
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = null,
                    tint = RebalanceColors.neutral0
                )
            }
        }
    }
}
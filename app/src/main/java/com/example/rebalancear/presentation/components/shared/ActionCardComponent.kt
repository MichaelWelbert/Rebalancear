package com.example.rebalancear.presentation.components.shared


import android.icu.text.NumberFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.rebalancear.R
import com.example.rebalancear.core.ContributeState
import com.example.rebalancear.core.RebalanceStrings
import com.example.rebalancear.routes.Routes
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors

@Composable
fun ActionCardComponent(
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    backgroundColors: List<Color>,
    tittleBackgroundColor: Color
) {
    BoxWithConstraints(
        modifier = Modifier.clickable {
            onClick()
        }
    ) {
        val boxWidth = this.maxWidth

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp,
                    end = 16.dp,
                    start = 16.dp,
                ),
        ) {
            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .width(10.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()

                    .shadow(
                        10.dp,
                        RoundedCornerShape(
                           20
                        ),
                        true,
                    )
                    .background(
                        brush = Brush.horizontalGradient(colors = backgroundColors)
                    )

                    .padding(
                        top = 40.dp,
                        bottom = 28.dp,
                        start = 28.dp,
                        end = 28.dp
                    ),

                ) {

                Text(
                    modifier = Modifier,
                    text = subtitle,
                    color = RebalanceColors.white,
                    style = ReBalanceTypography.Body3,
                )

            }


        }

        Box(
            modifier = Modifier
                .width((boxWidth.value * 0.4).dp)
                .align(Alignment.TopStart)
                .padding(
                    top = 16.dp,
                    end = 16.dp,
                    start = 16.dp,
                )
                .clip(
                    RoundedCornerShape(
                        topStart = 60.dp,
                        bottomStart = 2.dp,
                        bottomEnd = 80.dp,
                        topEnd = 80.dp
                    )
                )

                .background(tittleBackgroundColor)

        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                text = title,
                color = Color.White,
                style = ReBalanceTypography.Strong3,
                textAlign = TextAlign.Center
            )
        }
    }
}

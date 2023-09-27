package com.example.rebalancear.presentation.screen.error

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.R
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.Colors


@Composable
internal fun ErrorPageComponent(
    message: String,
) {
    ErrorBasePageComponent(
        title = "Oops! Ocorreu um erro",
        subTitle = message,
        image = R.drawable.mascot_male_2
    )
}


@Composable
private fun ErrorBasePageComponent(
    title: String,
    subTitle: String,
    @DrawableRes image: Int,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,

        ) {

        Image(
            modifier = Modifier
                .scale(1.2f)
                .fillMaxWidth(),
            painter = painterResource(id = image),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = title,
            color = Colors.blackColor.copy(alpha = 0.7f),
            style = ReBalanceTypography.Strong5,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = subTitle,
            color = Colors.blackColor.copy(alpha = 0.7f),
            style = ReBalanceTypography.Body3,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))
    }

}
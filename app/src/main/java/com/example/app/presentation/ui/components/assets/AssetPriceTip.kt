package com.example.app.presentation.ui.components.assets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.core.strings.Format
import com.example.app.presentation.theme.Colors
import com.example.app.presentation.theme.ThemeTypography
import com.example.rebalancear.R

@Composable
fun AssetPriceTip(
    unitsGoal: Float,
    price: Float,
) {
    Row(
        Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .width(100.dp),
            painter = painterResource(id = R.drawable.mascot_male_2),
            contentDescription = null,
        )

        Column {
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                text = "APROXIMADAMENTE",
                color = Colors.whiteColor,
                style = ThemeTypography.peaceSans.body16,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                text = coloredComma(Format.convertFloatToPriceFormat(price)),
                color = Colors.whiteColor,
                style = ThemeTypography.peaceSans.body22,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(6.dp))
            Box(modifier = Modifier.padding(horizontal = 40.dp))
            {
                Divider(
                    color = Colors.whiteColor,
                    thickness = 1.5.dp,
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                text = "PARA ATINGIR SUA META, COMPRE CERCA DE ${unitsGoal.toInt()} AÇÕES",
                color = Colors.whiteColor,
                style = ThemeTypography.roboto.body14,
                textAlign = TextAlign.Center
            )
        }
    }

}



private fun coloredComma(
    text: String,
): AnnotatedString {

    val spanStyle = SpanStyle(color = Colors.pinkColor)

    val commaIndex = text.indexOf(",")
    val firstPart = text.substring(0, commaIndex)
    val coloredPart = text[commaIndex]
    val lastPart = text.substring(commaIndex + 1, text.length)

    return buildAnnotatedString {

        append(firstPart)
        withStyle(style = spanStyle) {
            append(coloredPart)
        }
        append(lastPart)
    }
}

@Preview
@Composable
fun Preview() {
    AssetPriceTip(
        unitsGoal = 30f,
        30.25f
    )
}
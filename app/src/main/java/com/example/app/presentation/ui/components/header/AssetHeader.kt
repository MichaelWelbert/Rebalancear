package com.example.app.presentation.ui.components.header

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.presentation.theme.Colors
import com.example.rebalancear.presentation.ui.theme.style


@Composable
fun AssetHeader(
    assetCode: String,
) {
    Box(
        Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 32.dp, bottom = 16.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .padding(top = 12.dp)
                .offset((-25).dp, (-15).dp),
            text = assetCode,
            color = Color.White.copy(alpha = 0.1f),
            style = style.Body5.copy(
                fontSize = 50.sp,
                letterSpacing = (0).sp
            ),
            textAlign = TextAlign.End
        )

        Text(
            modifier = Modifier
                .padding(top = 12.dp)
                .offset(25.dp),
            text = coloredText(assetCode),
            color = Color.White,
            style = style.Body5.copy(
                fontSize = 50.sp,
                letterSpacing = (0).sp
            ),
            textAlign = TextAlign.End
        )
    }
}

private fun coloredText(
    text: String,
): AnnotatedString {

    val spanStyle = SpanStyle(color = Colors.pinkColor)

    if (text.count() < 5)
        return buildAnnotatedString { append(text) }

    val firstPart = text.substring(0, 3)
    val coloredPart = text[3]
    val lastPart = text.substring(4, 5)

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
fun PreviewAssetHeader() {
    AssetHeader("BBSE3")
}
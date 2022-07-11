package com.example.rebalancear.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.rebalancear.R

private val Mulish = FontFamily(
    Font(R.font.mulish_medium, FontWeight.Medium),
    Font(R.font.mulish_extra_bold, FontWeight.ExtraBold),
    Font(R.font.mulish_black_italic, FontWeight.Black)
)

object ReBalanceTypography {
    val Tittle = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.Black,
        fontStyle = FontStyle.Italic,
        fontSize = 18.sp,
        lineHeight = (1.2).em,
        letterSpacing = (-0.02).em
    )


    val Body1 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 10.sp,
        lineHeight = (1.37).em,
        letterSpacing = 0.sp
    )

    val Body2 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 12.sp,
        lineHeight = (1.37).em,
        letterSpacing = 0.sp
    )

    val Body3 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp,
        lineHeight = (1.37).em,
        letterSpacing = 0.sp
    )

    val Body4 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp,
        lineHeight = (1.37).em,
        letterSpacing = 0.sp
    )

    val Body5 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 18.sp,
        lineHeight = (1.37).em,
        letterSpacing = 0.sp
    )

    val Strong1 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 10.sp,
        lineHeight = (1.37).em,
        letterSpacing = 0.sp
    )

    val Strong2 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 12.sp,
        lineHeight = (1.37).em,
        letterSpacing = 0.sp
    )

    val Strong3 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp,
        lineHeight = (1.37).em,
        letterSpacing = 0.sp
    )

    val Strong4 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp,
        lineHeight = (1.37).em,
        letterSpacing = 0.sp
    )

    val Strong5 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 18.sp,
        lineHeight = (1.37).em,
        letterSpacing = 0.sp
    )

    val Paragraph1 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 10.sp,
        lineHeight = (1.6).em,
        letterSpacing = 0.sp
    )

    val Paragraph2 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 12.sp,
        lineHeight = (1.6).em,
        letterSpacing = 0.sp
    )

    val Paragraph3 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp,
        lineHeight = (1.6).em,
        letterSpacing = 0.sp
    )

    val Paragraph4 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp,
        lineHeight = (1.6).em,
        letterSpacing = 0.sp
    )

    val Paragraph5 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 18.sp,
        lineHeight = (1.6).em,
        letterSpacing = 0.sp
    )

    val Heading1 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 36.sp,
        lineHeight = (1.2).em,
        letterSpacing = (-0.02).em
    )

    val Heading2 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 32.sp,
        lineHeight = (1.2).em,
        letterSpacing = (-0.02).em
    )

    val Heading3 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 28.sp,
        lineHeight = (1.2).em,
        letterSpacing = (-0.02).em
    )

    val Heading4 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 24.sp,
        lineHeight = (1.2).em,
        letterSpacing = (-0.02).em
    )

    val Heading5 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 22.sp,
        lineHeight = (1.24).em,
        letterSpacing = (-0.005).em
    )

    val Heading6 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 20.sp,
        lineHeight = (1.24).em,
        letterSpacing = (-0.005).em
    )

    val Display1 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 60.sp,
        lineHeight = (1.2).em,
        letterSpacing = (-0.02).em
    )

    val Display2 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 48.sp,
        lineHeight = (1.2).em,
        letterSpacing = (-0.02).em
    )

    val Display3 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 44.sp,
        lineHeight = (1.2).em,
        letterSpacing = (-0.02).em
    )

    val Display4 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 40.sp,
        lineHeight = (1.2).em,
        letterSpacing = (-0.02).em
    )
}

val ComposeTypography = Typography(
    defaultFontFamily = Mulish,
    h1 = ReBalanceTypography.Heading1,
    h2 = ReBalanceTypography.Heading2,
    h3 = ReBalanceTypography.Heading3,
    h4 = ReBalanceTypography.Heading4,
    h5 = ReBalanceTypography.Heading5,
    h6 = ReBalanceTypography.Heading6,
    body1 = ReBalanceTypography.Body1,
    body2 = ReBalanceTypography.Body2
)

@Preview
@Composable
fun PreviewTypography() {
    RebalanceTheme {
        Surface {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "body1", style = ReBalanceTypography.Body1)
                        Text(text = "body2", style = ReBalanceTypography.Body2)
                        Text(text = "body3", style = ReBalanceTypography.Body3)
                        Text(text = "body4", style = ReBalanceTypography.Body4)
                        Text(text = "body5", style = ReBalanceTypography.Body5)
                    }
                    Column {
                        Text(text = "strong1", style = ReBalanceTypography.Strong1)
                        Text(text = "strong2", style = ReBalanceTypography.Strong2)
                        Text(text = "strong3", style = ReBalanceTypography.Strong3)
                        Text(text = "strong4", style = ReBalanceTypography.Strong4)
                        Text(text = "strong5", style = ReBalanceTypography.Strong5)
                    }
                    Column {
                        Text(text = "paragraph1", style = ReBalanceTypography.Paragraph1)
                        Text(text = "paragraph2", style = ReBalanceTypography.Paragraph2)
                        Text(text = "paragraph3", style = ReBalanceTypography.Paragraph3)
                        Text(text = "paragraph4", style = ReBalanceTypography.Paragraph4)
                        Text(text = "paragraph5", style = ReBalanceTypography.Paragraph5)
                    }
                }
                Row {
                    Column {
                        Text(text = "heading1", style = ReBalanceTypography.Heading1)
                        Text(text = "heading2", style = ReBalanceTypography.Heading2)
                        Text(text = "heading3", style = ReBalanceTypography.Heading3)
                        Text(text = "heading4", style = ReBalanceTypography.Heading4)
                        Text(text = "heading5", style = ReBalanceTypography.Heading5)
                        Text(text = "heading6", style = ReBalanceTypography.Heading6)
                    }
                    Column {
                        Text(text = "display1", style = ReBalanceTypography.Display1)
                        Text(text = "display2", style = ReBalanceTypography.Display2)
                        Text(text = "display3", style = ReBalanceTypography.Display3)
                        Text(text = "display4", style = ReBalanceTypography.Display4)
                    }
                }
            }
        }
    }
}
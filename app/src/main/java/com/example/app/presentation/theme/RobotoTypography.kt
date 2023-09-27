package com.example.app.presentation.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.rebalancear.R

private val Roboto = FontFamily(
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_black, FontWeight.ExtraBold),
    Font(R.font.roboto_black_italic, FontWeight.Black)
)

private val baseBody = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Medium,
    fontStyle = FontStyle.Normal,
    lineHeight = (1.37).em,
    letterSpacing = 0.sp
)

private val baseStrong = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.ExtraBold,
    fontStyle = FontStyle.Normal,
    lineHeight = (1.37).em,
    letterSpacing = 0.sp
)

private val baseHeading = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.ExtraBold,
    fontStyle = FontStyle.Normal,
    lineHeight = (1.2).em,
    letterSpacing = (-0.02).em
)

class RobotoTypography {
    val fontFamily = Roboto

    val body10 = baseBody.copy(fontSize = 10.sp)
    val body12 = baseBody.copy(fontSize = 12.sp)
    val body14 = baseBody.copy(fontSize = 14.sp)
    val body16 = baseBody.copy(fontSize = 16.sp)
    val body18 = baseBody.copy(fontSize = 18.sp)
    val body20 = baseBody.copy(fontSize = 20.sp)
    val body22 = baseBody.copy(fontSize = 22.sp)
    val body24 = baseBody.copy(fontSize = 24.sp)
    val body36 = baseBody.copy(fontSize = 36.sp)
    val body48 = baseBody.copy(fontSize = 48.sp)

    val strong10 = baseStrong.copy(fontSize = 10.sp)
    val strong14 = baseStrong.copy(fontSize = 14.sp)
    val strong12 = baseStrong.copy(fontSize = 12.sp)
    val strong16 = baseStrong.copy(fontSize = 16.sp)
    val strong18 = baseStrong.copy(fontSize = 18.sp)
    val strong20 = baseStrong.copy(fontSize = 20.sp)
    val strong22 = baseStrong.copy(fontSize = 22.sp)
    val strong24 = baseStrong.copy(fontSize = 24.sp)
    val strong28 = baseStrong.copy(fontSize = 28.sp)
    val strong32 = baseStrong.copy(fontSize = 32.sp)
    val strong36 = baseStrong.copy(fontSize = 36.sp)
    val strong48 = baseStrong.copy(fontSize = 48.sp)

}


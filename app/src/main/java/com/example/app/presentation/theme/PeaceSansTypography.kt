package com.example.app.presentation.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.rebalancear.R

private val PeaceSans = FontFamily(
    Font(R.font.peace_sans, FontWeight.Medium),
)

private val baseBody = TextStyle(
    fontFamily = PeaceSans,
    fontWeight = FontWeight.Medium,
    fontStyle = FontStyle.Normal,
    lineHeight = (1.37).em,
    letterSpacing = 0.sp
)

class PeaceSansTypography {
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
}


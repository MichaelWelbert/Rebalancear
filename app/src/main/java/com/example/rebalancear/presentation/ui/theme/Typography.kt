package com.example.rebalancear.presentation.ui.theme

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
private val Roboto = FontFamily(
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_black, FontWeight.ExtraBold),
    Font(R.font.roboto_black_italic, FontWeight.Black)
)

class PeaceSansTypography {
     val Body1 = TextStyle(
         fontFamily = PeaceSans,
         fontWeight = FontWeight.Medium,
         fontStyle = FontStyle.Normal,
         fontSize = 10.sp,
         lineHeight = (1.37).em,
         letterSpacing = 0.sp
     )

     val Body2 = TextStyle(
         fontFamily = PeaceSans,
         fontWeight = FontWeight.Medium,
         fontStyle = FontStyle.Normal,
         fontSize = 12.sp,
         lineHeight = (1.37).em,
         letterSpacing = 0.sp
     )

     val Body3 = TextStyle(
         fontFamily = PeaceSans,
         fontWeight = FontWeight.Medium,
         fontStyle = FontStyle.Normal,
         fontSize = 14.sp,
         lineHeight = (1.37).em,
         letterSpacing = 0.sp
     )

     val Body4 = TextStyle(
         fontFamily = PeaceSans,
         fontWeight = FontWeight.Medium,
         fontStyle = FontStyle.Normal,
         fontSize = 16.sp,
         lineHeight = (1.37).em,
         letterSpacing = 0.sp
     )

    val Body5 = TextStyle(
        fontFamily = PeaceSans,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 18.sp,
        lineHeight = (1.37).em,
        letterSpacing = 0.sp
    )

     val BodyR1 = TextStyle(
         fontFamily = Roboto,
         fontWeight = FontWeight.Medium,
         fontStyle = FontStyle.Normal,
         fontSize = 10.sp,
         lineHeight = (1.37).em,
         letterSpacing = 0.sp
     )


    val BodyR2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 12.sp,
        lineHeight = (1.37).em,
        letterSpacing = 0.sp
    )



     val Body7 = TextStyle(
         fontFamily = PeaceSans,
         fontWeight = FontWeight.Medium,
         fontStyle = FontStyle.Normal,
         fontSize = 22.sp,
         lineHeight = (1.37).em,
         letterSpacing = 0.sp
     )

    val Body8 = TextStyle(
        fontFamily = PeaceSans,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 24.sp,
        lineHeight = (1.37).em,
        letterSpacing = 0.sp
    )

     val Strong1 = TextStyle(
         fontFamily = PeaceSans,
         fontWeight = FontWeight.ExtraBold,
         fontStyle = FontStyle.Normal,
         fontSize = 10.sp,
         lineHeight = (1.37).em,
         letterSpacing = 0.sp
     )

     val Strong2 = TextStyle(
         fontFamily = PeaceSans,
         fontWeight = FontWeight.ExtraBold,
         fontStyle = FontStyle.Normal,
         fontSize = 12.sp,
         lineHeight = (1.37).em,
         letterSpacing = 0.sp
     )

     val Strong3 = TextStyle(
         fontFamily = PeaceSans,
         fontWeight = FontWeight.ExtraBold,
         fontStyle = FontStyle.Normal,
         fontSize = 14.sp,
         lineHeight = (1.37).em,
         letterSpacing = 0.sp
     )

     val Strong4 = TextStyle(
         fontFamily = PeaceSans,
         fontWeight = FontWeight.ExtraBold,
         fontStyle = FontStyle.Normal,
         fontSize = 16.sp,
         lineHeight = (1.37).em,
         letterSpacing = 0.sp
     )

     val Strong5 = TextStyle(
         fontFamily = PeaceSans,
         fontWeight = FontWeight.ExtraBold,
         fontStyle = FontStyle.Normal,
         fontSize = 18.sp,
         lineHeight = (1.37).em,
         letterSpacing = 0.sp
     )
 }

val style = PeaceSansTypography()
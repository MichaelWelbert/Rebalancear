package com.example.rebalancear.presentation.ui.theme

import androidx.compose.ui.graphics.Color

interface IRebalanceColors {

    val primaryColor: Color
    val secondaryColor: Color

    val rightColor: Color
    val wrongColor: Color

    val blackColor: Color
    val greyColor: Color
    val whiteColor: Color

    val neutral0: Color
    val neutral100: Color
    val neutral200: Color
    val neutral300: Color
    val neutral400: Color
    val neutral450: Color
    val neutral500: Color


    val yellow0: Color
    val yellow100: Color
    val yellow200: Color
    val yellow300: Color
    val yellow400: Color
    val yellow500: Color

    val green0: Color
    val green100: Color
    val green200: Color
    val green300: Color
    val green400: Color
    val green500: Color

    val red0: Color
    val red100: Color
    val red200: Color
    val red300: Color
    val red400: Color
    val red500: Color

    val pink0: Color
    val pink100: Color
    val pink200: Color
    val pink300: Color
    val pink400: Color
    val pink500: Color
}


object RebalanceColors : IRebalanceColors {
    override val primaryColor: Color = Color(0xFF465367)
    override val secondaryColor: Color = Color(0xFFDB9953)
    override val wrongColor: Color = Color(0xFFCE7E7E)
    override val rightColor: Color = Color(0xFF66AFAD)
    override val whiteColor : Color = Color(0xFFFEFEFE)
    override val blackColor: Color = Color(0xFF2D2C35)
    override val greyColor: Color = Color(0xFFC1C3C7)

    override val neutral0 = Color(0xFFFEFEFE)
    override val neutral100 = Color(0xFFFCFCFD)
    override val neutral200 = Color(0xFFC1C3C7)
    override val neutral300 = Color(0xFFA6A7A4)
    override val neutral400 = Color(0xFF464646)
    override val neutral450 = Color(0xFF465367)
    override val neutral500 = Color(0xFF2D2C35)

    override val green0 = Color(0xFFB0EDFC)
    override val green100 = Color(0xFF66AFAD)
    override val green200 = Color(0xFF36807E)
    override val green300 = Color(0xFF2F4B4F)
    override val green400 = Color(0xFF294545)
    override val green500 = Color(0xFF1D3031)

    override val red0 = Color(0xFFF8CAD7)
    override val red100 = Color(0xFFCE7E7E)
    override val red200 = Color(0xFF80364B)
    override val red300 = Color(0xFF4F2F38)
    override val red400 = Color(0xFF452930)
    override val red500 = Color(0xFFed2429)

    override val yellow0 = Color(0xFFF8E9CA)
    override val yellow100 = Color(0xFFDB9953)
    override val yellow200 = Color(0xFF807C36)
    override val yellow300 = Color(0xFF4F4A2F)
    override val yellow400 = Color(0xFF453E29)
    override val yellow500 = Color(0xFF312D1D)


    override val pink0 = Color(0xFFF8CAE9)
    override val pink100 = Color(0xFFAF6694)
    override val pink200 = Color(0xFF803679)
    override val pink300 = Color(0xFF4F2F4C)
    override val pink400 = Color(0xFF452940)
    override val pink500 = Color(0xFF311D2D)

}
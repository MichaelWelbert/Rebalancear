package com.example.rebalancear.presentation.ui.theme

import androidx.compose.ui.graphics.Color

interface IRebalanceColors {

    val primaryColor: Color
    val secondaryColor: Color
    val secondaryLightColor : Color
    val thirdColor: Color

    val blackColor: Color
    val greyColor: Color
    val whiteColor: Color
}


object Colors : IRebalanceColors {
    override val primaryColor: Color = Color(0xFF383838)
    override val secondaryColor: Color = Color(0xFFF652A0)
    override val secondaryLightColor: Color = Color(0xFFFFF8FF)
    override val thirdColor: Color = Color(0xFF368F8B)
    override val whiteColor : Color = Color(0xFFFEFEFE)
    override val blackColor: Color = Color(0xFF282828)
    override val greyColor: Color = Color(0xFFC1C3C7)
}
package com.example.rebalancear.ui.theme

import androidx.compose.ui.graphics.Color

interface IRebalanceColors {
    val white: Color
    val black: Color

    val lightOceanBlue: Color
    val darkOceanBlue: Color

    val lightBlue: Color
    val darkBlue: Color

    val lightRed: Color
    val darkRed: Color


    val lightGold: Color
    val darkGold: Color


    val lightYellow: Color
    val darkYellow: Color

    val lightGrey: Color
    val darkGrey: Color
}

object RebalanceColors : IRebalanceColors {
    override val white = Color(0xFFF7EFED)

    override val lightOceanBlue = Color(0xFF28BEC0)
    override val darkOceanBlue = Color(0xFF437B8B)

    override val lightRed = Color(0xFFFF4646)
    override val darkRed = Color(0xFF923A3A)

    override val lightBlue = Color(0xFF007B9E)
    override val darkBlue = Color(0xFF006B8A)

    override val lightGrey = Color(0xFF535353)
    override val darkGrey = Color(0xFF2D2C35)

    override val lightYellow = Color(0xFFFABA4B)
    override val darkYellow = Color(0xFFBD783C)

    override val lightGold = Color(0xFF4A8577)
    override val darkGold = Color(0xFF326458)


    override val black = Color.Black
}
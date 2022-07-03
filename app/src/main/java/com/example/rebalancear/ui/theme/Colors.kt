package com.example.rebalancear.ui.theme

import androidx.compose.ui.graphics.Color

interface IRebalanceColors {
    val white: Color
    val black: Color

    val lightBlue: Color
    val darkBlue: Color
    val lightYellow: Color
    val darkYellow: Color
    val lightRed: Color
    val darkRed: Color
    val lightGrey: Color
    val darkGrey: Color
}

object RebalanceColors : IRebalanceColors {
    override val white = Color(0xFFF7EFED)

    override val  lightBlue = Color(0xFF1AE8EB)
    override val  darkBlue = Color(0xFF437B8B)

    override val  lightRed = Color(0xFFFA4B4B)
    override val  darkRed = Color(0xFF923A3A)

    override val  lightYellow = Color(0xFFFABA4B)
    override val  darkYellow = Color(0xFFBD783C)

    override val  lightGrey = Color(0xFF535353)
    override val  darkGrey = Color(0xFF2D2C35)

    override val black = Color.Black
}
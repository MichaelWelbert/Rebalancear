package com.example.rebalancear.ui.theme

import androidx.compose.ui.graphics.Color

interface IRebalanceColors {
    val white: Color
    val black: Color

    val lightOceanBlue: Color
    val darkOceanBlue: Color

    val lightBlue: Color
    val darkBlue: Color

    val strongDarkBlue: Color
    val strongLightBlue: Color

    val lightRed: Color
    val darkRed: Color

    val lightOrange: Color
    val normalOrange: Color
    val darkOrange: Color

    val lightGreen: Color
    val normalGreen: Color
    val darkGreen: Color


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

    override val lightGrey = Color(0xFF909096)
    override val darkGrey = Color(0xFF2D2C35)

    override val strongDarkBlue = Color(0xFF16152E)
    override val strongLightBlue = Color(0xFF1E1D34)

    override val lightOrange = Color(0xFFFF8438)
    override val normalOrange = Color(0xFFCB5914)
    override val darkOrange = Color(0xFFC64C01)

    override val lightYellow = Color(0xFFFABA4B)
    override val darkYellow = Color(0xFFBD783C)

    override val lightGreen = Color(0xFF46BB78)
    override val normalGreen = Color(0xFF077937)
    override val darkGreen = Color(0xFF00692D)


    override val black = Color.Black
}
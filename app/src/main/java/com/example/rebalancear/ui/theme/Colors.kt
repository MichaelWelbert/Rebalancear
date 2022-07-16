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

    val lightYellow: Color
    val darkYellow: Color

    val lightGrey: Color
    val darkGrey: Color

    val green0: Color
    val green100: Color
    val green200: Color
    val green300: Color
    val green400: Color
    val green500: Color



    val orange0: Color
    val orange100: Color
    val orange200: Color
    val orange300: Color
    val orange400: Color
    val orange500: Color
}

object RebalanceColors : IRebalanceColors {
    override val white = Color(0xFFDDDDE0)

    override val lightOceanBlue = Color(0xFF28BEC0)
    override val darkOceanBlue = Color(0xFF437B8B)

    override val lightRed = Color(0xFFFF4646)
    override val darkRed = Color(0xFF923A3A)

    override val lightBlue = Color(0xFF007B9E)
    override val darkBlue = Color(0xFF006B8A)

    override val lightGrey = Color(0xFF909096)
    override val darkGrey = Color(0xFF2D2C35)

    override val strongDarkBlue = Color(0xFF21152E)
    override val strongLightBlue = Color(0xFF271D34)

    override val lightOrange = Color(0xFFF58948)
    override val normalOrange = Color(0xFFBD6B3A)
    override val darkOrange = Color(0xFFC64C01)

    override val lightYellow = Color(0xFFFABA4B)
    override val darkYellow = Color(0xFFBD783C)


    override val green0 =  Color(0xFFCAF8ED)
    override val green100 = Color(0xFF56CEB2)
    override val green200 = Color(0xFF368075)
    override val green300 = Color(0xFF2F4F48)
    override val green400 =Color(0xFF294541)
    override val green500 =  Color(0xFF1D312E)

    override val orange0 =  Color(0xFFF8D7CA)
    override val orange100 = Color(0xFFCE7856)
    override val orange200 = Color(0xFF804D36)
    override val orange300 = Color(0xFF4F392F)
    override val orange400 =Color(0xFF453129)
    override val orange500 =  Color(0xFF31211D)


    override val black = Color.Black
}
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

    val lightred: Color
    val normalred: Color
    val darkred: Color

    val lightYellow: Color
    val darkYellow: Color

    val lightGrey: Color
    val darkGrey: Color


    val neutral0: Color
    val neutral100: Color
    val neutral200: Color
    val neutral300: Color
    val neutral400: Color
    val neutral500: Color


    val purple0: Color
    val purple100: Color
    val purple200: Color
    val purple300: Color
    val purple400: Color
    val purple500: Color

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

    override val lightred = Color(0xFFF58948)
    override val normalred = Color(0xFFBD6B3A)
    override val darkred = Color(0xFFC64C01)

    override val lightYellow = Color(0xFFFABA4B)
    override val darkYellow = Color(0xFFBD783C)


    override val neutral0 =  Color(0xFFD8D2DD)
    override val neutral100 = Color(0xFFBBB5BD)
    override val neutral200 = Color(0xFF838086)
    override val neutral300 = Color(0xFF434147)
    override val neutral400 =Color(0xFF312D33)
    override val neutral500 =  Color(0xFF2D2930)



    override val green0 =  Color(0xFFB0EDFC)
    override val green100 = Color(0xFF66AFAD)
    override val green200 = Color(0xFF36807E)
    override val green300 = Color(0xFF2F4B4F)
    override val green400 =Color(0xFF294545)
    override val green500 =  Color(0xFF1D3031)


    override val red0 =   Color(0xFFF8CAD7)
    override val red100 = Color(0xFFCE7E7E)
    override val red200 = Color(0xFF80364B)
    override val red300 = Color(0xFF4F2F38)
    override val red400 =Color(0xFF452930)
    override val red500 = Color(0xFF311D22)


    override val purple0 =  Color(0xFFDDCAF8)
    override val purple100 = Color(0xFF8066AF)
    override val purple200 = Color(0xFF593680)
    override val purple300 = Color(0xFF352F4F)
    override val purple400 =Color(0xFF352945)
    override val purple500 =   Color(0xFF251D31)


    override val black = Color.Black
}
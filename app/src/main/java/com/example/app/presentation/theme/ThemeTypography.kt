package com.example.app.presentation.theme

import androidx.compose.material.Typography


object ThemeTypography {
    val roboto = RobotoTypography()
    val peaceSans = PeaceSansTypography()
    val base = Typography(
        defaultFontFamily = roboto.fontFamily,
        body1 = roboto.body10,
        body2 = roboto.body12
    )
}


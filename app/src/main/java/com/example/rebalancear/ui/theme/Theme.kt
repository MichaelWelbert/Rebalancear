package com.example.pendulum.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
@Composable
fun RebalanceTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        typography = ComposeTypography,
        content = content
    )
}
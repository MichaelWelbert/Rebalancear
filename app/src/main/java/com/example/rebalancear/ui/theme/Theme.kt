package com.example.rebalancear.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.rebalancear.ui.theme.ComposeTypography

@Composable
fun RebalanceTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        typography = ComposeTypography,
        content = content
    )
}
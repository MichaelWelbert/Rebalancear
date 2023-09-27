package com.example.app.presentation.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        typography = ThemeTypography.base,
        content = content
    )
}



@Preview
@Composable
fun PreviewTypography() {
    AppTheme {
        Surface {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "body10", style = ThemeTypography.roboto.body10)
                        Text(text = "body12", style = ThemeTypography.roboto.body12)
                        Text(text = "body14", style = ThemeTypography.roboto.body14)
                        Text(text = "body16", style = ThemeTypography.roboto.body16)
                        Text(text = "body18", style = ThemeTypography.roboto.body18)
                        Text(text = "body20", style = ThemeTypography.roboto.body20)
                        Text(text = "body22", style = ThemeTypography.roboto.body22)
                        Text(text = "body24", style = ThemeTypography.roboto.body24)
                        Text(text = "body36", style = ThemeTypography.roboto.body36)
                        Text(text = "body48", style = ThemeTypography.roboto.body48)
                    }
                    Column {
                        Text(text = "body10", style = ThemeTypography.peaceSans.body10)
                        Text(text = "body12", style = ThemeTypography.peaceSans.body12)
                        Text(text = "body14", style = ThemeTypography.peaceSans.body14)
                        Text(text = "body16", style = ThemeTypography.peaceSans.body16)
                        Text(text = "body18", style = ThemeTypography.peaceSans.body18)
                        Text(text = "body20", style = ThemeTypography.peaceSans.body20)
                        Text(text = "body22", style = ThemeTypography.peaceSans.body22)
                        Text(text = "body24", style = ThemeTypography.peaceSans.body24)
                        Text(text = "body36", style = ThemeTypography.peaceSans.body36)
                        Text(text = "body48", style = ThemeTypography.peaceSans.body48)
                    }
                }
                Column {
                    Text(text = "strong10", style = ThemeTypography.roboto.strong10)
                    Text(text = "strong12", style = ThemeTypography.roboto.strong12)
                    Text(text = "strong14", style = ThemeTypography.roboto.strong14)
                    Text(text = "strong16", style = ThemeTypography.roboto.strong16)
                    Text(text = "strong18", style = ThemeTypography.roboto.strong18)
                    Text(text = "strong20", style = ThemeTypography.roboto.strong20)
                    Text(text = "strong22", style = ThemeTypography.roboto.strong22)
                    Text(text = "strong24", style = ThemeTypography.roboto.strong24)
                    Text(text = "strong28", style = ThemeTypography.roboto.strong28)
                    Text(text = "strong32", style = ThemeTypography.roboto.strong32)
                    Text(text = "strong36", style = ThemeTypography.roboto.strong36)
                    Text(text = "strong48", style = ThemeTypography.roboto.strong48)
                }
            }
        }

    }
}
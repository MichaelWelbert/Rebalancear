package com.example.rebalancear.presentation.screen.wallet.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography

@Composable
internal fun AddWalletAssetDialog(
    modifier: Modifier = Modifier,
    enable: Boolean,
    onAdd: (code: String, units: Double, goal: Double) -> Unit,
    onCancel: () -> Unit
) {
    if (enable) {
        Box(modifier = Modifier
            .fillMaxSize()
            .clickable { }) {
            DialogWalletAsset(
                modifier = modifier,
                onAdd = onAdd,
                onCancel = onCancel,
            )
        }
    }

}

@Composable
private fun DialogWalletAsset(
    modifier: Modifier = Modifier,
    onAdd: (code: String, units: Double, goal: Double) -> Unit,
    onCancel: () -> Unit,
) {
    var code by remember { mutableStateOf("") }
    var units by remember { mutableStateOf("") }
    var goal by remember { mutableStateOf("") }

    Column(
        modifier = modifier,
    ) {
        TextField(
            value = code,
            onValueChange = { code = it },
            label = { Text("Enter code") },
            maxLines = 2,
            textStyle = ReBalanceTypography.Strong3,
            modifier = Modifier
        )

        TextField(
            value = units,
            onValueChange = { units = it },
            label = { Text("Enter units") },
            maxLines = 2,
            textStyle = ReBalanceTypography.Strong3,
            modifier = Modifier
        )

        TextField(
            value = goal,
            onValueChange = { goal = it },
            label = { Text("Enter goal") },
            maxLines = 2,
            textStyle = ReBalanceTypography.Strong3,
            modifier = Modifier
        )

        Row() {
            TextButton(onClick = {
                onCancel()
            }) {
                Text(text = "Cancelar")
            }

            TextButton(onClick = {
                onAdd(code, units.toDouble(), goal.toDouble())
            }) {
                Text(text = "Adicionar")
            }
        }
    }
}
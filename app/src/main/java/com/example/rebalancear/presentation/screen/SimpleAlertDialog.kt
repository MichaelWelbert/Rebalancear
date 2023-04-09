package com.example.rebalancear.presentation.screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rebalancear.ui.theme.ReBalanceTypography

@Composable
fun SimpleAlertDialog(content: String, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        modifier = Modifier.fillMaxWidth(),
        onDismissRequest = {
            onDismiss()
        },

        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {

                Text(
                    content,
                    modifier = Modifier.padding(vertical = 8.dp),
                    style = ReBalanceTypography.Body1
                )
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Não")
            }
        },
        confirmButton = {
            Button(onClick = { onConfirm() }) {
                Text("Sim")
            }
        }
    )
}
package com.example.rebalancear.presentation.screen.wallet.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

@Composable
internal fun AddWalletAssetDialog(
    modifier: Modifier = Modifier,
    enable: Boolean,
    onAdd: (code: String, units: Double, goal: Double) -> Unit,
    onCancel: () -> Unit
) {
    if (enable) {
        Box(modifier = modifier
            .fillMaxSize()
            .background(color = RebalanceColors.neutral500.copy(alpha = 0.9f))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { }) {
            DialogWalletAsset(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp)
                    .background(RebalanceColors.neutral300, RoundedCornerShape(20.dp))
                    .align(Alignment.Center),
                onAdd = onAdd,
                onCancel = onCancel,
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DialogWalletAsset(
    modifier: Modifier = Modifier,
    onAdd: (code: String, units: Double, goal: Double) -> Unit,
    onCancel: () -> Unit,
) {
    var code by remember { mutableStateOf("") }
    var units by remember { mutableStateOf("") }
    var goal by remember { mutableStateOf("") }

    var codeError by remember { mutableStateOf(false) }
    var unitsError by remember { mutableStateOf(false) }
    var goalError by remember { mutableStateOf(false) }

    Card(
        modifier = modifier,
        border = BorderStroke(
            1.dp, RebalanceColors.neutral500.copy(alpha = 0.5f),
        ),
        colors = CardDefaults.cardColors(RebalanceColors.neutral400)

    ) {
        Column(modifier = Modifier.padding(24.dp)) {

            OutlinedTextField(
                modifier = Modifier,
                value = code,
                onValueChange = { code = it },
                isError = codeError,
                placeholder = {
                    Text(
                        "BBAS3",
                        color = RebalanceColors.neutral0.copy(alpha = 0.3f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                label = {
                    Text(
                        "Código da ação",
                        color = RebalanceColors.neutral0.copy(alpha = 0.8f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                singleLine = true,
                textStyle = ReBalanceTypography.Strong3,
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    errorCursorColor = RebalanceColors.red100,
                    errorBorderColor = RebalanceColors.red100,
                    containerColor = RebalanceColors.neutral300,
                    unfocusedBorderColor = RebalanceColors.neutral200,
                    focusedBorderColor = RebalanceColors.neutral200,
                    cursorColor = RebalanceColors.neutral200,
                    textColor = RebalanceColors.neutral0
                )
            )

            if(codeError) {
                Text(
                    "código Invalido",
                    color = RebalanceColors.red100,
                    style = ReBalanceTypography.Body3,
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier,
                value = units,
                onValueChange = { units = it },
                isError = unitsError,
                label = {
                    Text(
                        "Quantidade",
                        color = RebalanceColors.neutral0.copy(alpha = 0.8f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                placeholder = {
                    Text(
                        "10",
                        color = RebalanceColors.neutral0.copy(alpha = 0.3f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                singleLine = true,
                textStyle = ReBalanceTypography.Strong3,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    errorCursorColor = RebalanceColors.red100,
                    errorBorderColor = RebalanceColors.red100,
                    containerColor = RebalanceColors.neutral300,
                    unfocusedBorderColor = RebalanceColors.neutral200,
                    focusedBorderColor = RebalanceColors.neutral200,
                    cursorColor = RebalanceColors.neutral200,
                    textColor = RebalanceColors.neutral0
                )
            )

            if(unitsError) {
                Text(
                    "Quantidade invalida",
                    color = RebalanceColors.red100,
                    style = ReBalanceTypography.Body3,
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier,
                value = goal,
                onValueChange = { goal = it },
                isError = goalError,
                placeholder = {
                    Text(
                        "5",
                        color = RebalanceColors.neutral0.copy(alpha = 0.3f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                label = {
                    Text(
                        "Meta",
                        color = RebalanceColors.neutral0.copy(alpha = 0.8f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                singleLine = true,
                textStyle = ReBalanceTypography.Strong3,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    errorCursorColor = RebalanceColors.red100,
                    errorBorderColor = RebalanceColors.red100,
                    containerColor = RebalanceColors.neutral300,
                    unfocusedBorderColor = RebalanceColors.neutral200,
                    focusedBorderColor = RebalanceColors.neutral200,
                    cursorColor = RebalanceColors.neutral200,
                    textColor = RebalanceColors.neutral0
                )
            )

            if(goalError) {
                Text(
                    "meta invalida",
                    color = RebalanceColors.red100,
                    style = ReBalanceTypography.Body3,
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        if(code.isBlank())
                            codeError = true

                        if(units.isBlank())
                            unitsError = true

                        if(goal.isBlank())
                            goalError = true

                        if(codeError || unitsError || goalError)
                            return@Button

                        onAdd(code, units.toDouble(), goal.toDouble())
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, false),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 2.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = RebalanceColors.green200
                    ),
                    shape = RoundedCornerShape(20),

                    ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "Adicionar",
                        color = RebalanceColors.neutral0,
                        style = ReBalanceTypography.Strong3.copy(
                            textAlign = TextAlign.Start
                        ),
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = {
                        onCancel()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, false),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 2.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = RebalanceColors.red200
                    ),
                    shape = RoundedCornerShape(20),

                    ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "Cancelar",
                        color = RebalanceColors.neutral0,
                        style = ReBalanceTypography.Strong3.copy(
                            textAlign = TextAlign.Start
                        ),
                    )
                }
            }
        }
    }
}
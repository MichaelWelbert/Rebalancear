package com.example.rebalancear.presentation.screen.wallet.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

val validDecimalregex = """\d{1,2}(,\d{0,2})?""".toRegex()

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
            .background(color = RebalanceColors.blackColor.copy(alpha = 0.5f))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { }) {
            DialogWalletAsset(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .background(RebalanceColors.neutral0, RoundedCornerShape(20.dp))
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

    var codeFocused by remember { mutableStateOf(false) }
    var unitsFocused by remember { mutableStateOf(false) }
    var goalFocused by remember { mutableStateOf(false) }


    val focusRequester = FocusRequester()

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(RebalanceColors.neutral0),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp),

        ) {
        Column(modifier = Modifier.padding(32.dp)) {

            OutlinedTextField(
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .onFocusChanged {
                        codeFocused = it.isFocused
                    },
                value = code,
                onValueChange = {
                    if (it.length > 6) return@OutlinedTextField

                    code = it.filter { symbol ->
                        symbol.isLetterOrDigit()
                    }
                },
                isError = codeError,
                placeholder = {
                    Text(
                        "BBAS3",
                        color = RebalanceColors.blackColor.copy(alpha = 0.3f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                label = {
                    Text(
                        "Código",
                        color = RebalanceColors.blackColor.copy(alpha = 0.8f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                singleLine = true,
                textStyle = ReBalanceTypography.Strong3,
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    errorCursorColor = RebalanceColors.wrongColor,
                    errorBorderColor = RebalanceColors.wrongColor,
                    containerColor = RebalanceColors.whiteColor,
                    unfocusedBorderColor = RebalanceColors.greyColor,
                    focusedBorderColor = RebalanceColors.primaryColor,
                    cursorColor = RebalanceColors.blackColor,
                    textColor = RebalanceColors.blackColor
                )
            )

            if (codeError) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Código inválido. Por favor, informe um código de ação existente.",
                    color = RebalanceColors.wrongColor,
                    style = ReBalanceTypography.Body2,
                )
            } else {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Qual é o código da ação que você gostaria de adicionar?",
                    color = getFocusedColor(codeFocused),
                    style = getFocusedStyle(codeFocused),
                )
            }


            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.onFocusChanged {
                    unitsFocused = it.isFocused
                },
                value = units,
                onValueChange = {
                    if (it.length > 10) return@OutlinedTextField

                    units = it.filter { symbol ->
                        symbol.isDigit()
                    }

                },
                isError = unitsError,
                label = {
                    Text(
                        "Quantidade",
                        color = RebalanceColors.blackColor.copy(alpha = 0.8f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                placeholder = {
                    Text(
                        "10",
                        color = RebalanceColors.blackColor.copy(alpha = 0.3f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                singleLine = true,
                textStyle = ReBalanceTypography.Strong3,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    errorCursorColor = RebalanceColors.wrongColor,
                    errorBorderColor = RebalanceColors.wrongColor,
                    containerColor = RebalanceColors.whiteColor,
                    unfocusedBorderColor = RebalanceColors.greyColor,
                    focusedBorderColor = RebalanceColors.primaryColor,
                    cursorColor = RebalanceColors.blackColor,
                    textColor = RebalanceColors.blackColor
                )
            )

            if (unitsError) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Quantidade inválida. Por favor, informe a quantidade de ações que você possui.",
                    color = RebalanceColors.wrongColor,
                    style = ReBalanceTypography.Body2,
                )
            } else {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Quantas ações você possui desse ativo?",
                    color = getFocusedColor(unitsFocused),
                    style = getFocusedStyle(unitsFocused),
                )
            }


            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                modifier = Modifier.onFocusChanged {
                    goalFocused = it.isFocused
                },
                value = goal,
                onValueChange = {
                    if (it.isEmpty()) goal = it
                    if (it.matches(validDecimalregex)) goal = it
                },
                isError = goalError,
                placeholder = {
                    Text(
                        "5",
                        color = RebalanceColors.blackColor.copy(alpha = 0.3f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                label = {
                    Text(
                        "Meta",
                        color = RebalanceColors.blackColor.copy(alpha = 0.8f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                singleLine = true,
                textStyle = ReBalanceTypography.Strong3,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    errorCursorColor = RebalanceColors.wrongColor,
                    errorBorderColor = RebalanceColors.wrongColor,
                    containerColor = RebalanceColors.whiteColor,
                    unfocusedBorderColor = RebalanceColors.greyColor,
                    focusedBorderColor = RebalanceColors.primaryColor,
                    cursorColor = RebalanceColors.blackColor,
                    textColor = RebalanceColors.blackColor
                )
            )

            if (goalError) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Porcentagem inválida. Certifique-se de digitar um número entre 0 e 100%.",
                    color = RebalanceColors.wrongColor,
                    style = ReBalanceTypography.Body2,
                )
            } else {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Quantos % da ação você deseja ter na sua carteira de investimentos?",
                    color = getFocusedColor(goalFocused),
                    style = getFocusedStyle(goalFocused),
                )
            }




            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        if (code.isBlank())
                            codeError = true

                        if (units.isBlank())
                            unitsError = true

                        if (goal.isBlank())
                            goalError = true

                        if (codeError || unitsError || goalError)
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
                        containerColor = RebalanceColors.yellow100
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
                        containerColor = RebalanceColors.primaryColor
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

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}


private fun getFocusedColor(isFocus: Boolean): Color {
    return if (isFocus)
        RebalanceColors.blackColor
    else
        RebalanceColors.blackColor.copy(alpha = 0.3f)
}

private fun getFocusedStyle(isFocus: Boolean): TextStyle {
    return if (isFocus)
        ReBalanceTypography.Strong2
    else
        ReBalanceTypography.Body2
}
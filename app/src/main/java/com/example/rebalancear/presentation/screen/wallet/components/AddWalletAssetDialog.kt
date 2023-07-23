package com.example.rebalancear.presentation.screen.wallet.components

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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.presentation.states.AddAssetState
import com.example.rebalancear.presentation.states.base.RequestState
import com.example.rebalancear.presentation.states.base.VisibleState
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

val validDecimalregex = """\d{1,2}(.\d{0,2})?""".toRegex()

@Composable
internal fun AddWalletAssetDialog(
    modifier: Modifier = Modifier,
    addAssetState: AddAssetState,
    onAdd: (code: String, units: Double, goal: Double) -> Unit,
    onCancel: () -> Unit
) {
    when (addAssetState.visibility) {
        VisibleState.Hide -> Unit
        VisibleState.Show -> {

            Box(modifier = modifier
                .fillMaxSize()
                .background(color = RebalanceColors.primaryColor.copy(alpha = 0.85f))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    if (addAssetState.state !is RequestState.Loading)
                        onCancel()
                }) {
                DialogWalletAsset(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp)
                        .background(RebalanceColors.whiteColor, RoundedCornerShape(20.dp))
                        .align(Alignment.Center),
                    addAssetState = addAssetState,
                    onAdd = onAdd,
                    onCancel = onCancel,
                )
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DialogWalletAsset(
    modifier: Modifier = Modifier,
    onAdd: (code: String, units: Double, goal: Double) -> Unit,
    addAssetState: AddAssetState,
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

    Card(
        modifier = modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) { },
        colors = CardDefaults.cardColors(RebalanceColors.whiteColor),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp),
    ) {

        Column(modifier = Modifier.padding(32.dp)) {
            AddCardTextField(
                isFocused = codeFocused,
                text = code,
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters),
                placeholderText = "BBAS3",
                labelText = "Código",
                hasError = codeError,
                errorText = "Código inválido. Por favor, informe um código de ação existente.",
                tipsText = "Qual é o código da ação que você gostaria de adicionar?",
                onFocusRequestChanged = { codeFocused = it },
                onTextChanged = {
                    if (it.length > 6) return@AddCardTextField
                    val newCode = it.filter { symbol -> symbol.isLetterOrDigit() }
                    code = newCode
                }
            )

            Spacer(modifier = Modifier.height(4.dp))

            AddCardTextField(
                isFocused = unitsFocused,
                text = units,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholderText = "10",
                labelText = "Quantidade",
                hasError = unitsError,
                errorText = "Quantidade inválida. Por favor, informe a quantidade de ações que você possui.",
                tipsText = "Quantas ações você possui desse ativo?",
                onFocusRequestChanged = { unitsFocused = it },
                onTextChanged = {
                    if (it.length > 10) return@AddCardTextField

                    units = it.filter { symbol ->
                        symbol.isDigit()
                    }
                }
            )

            Spacer(modifier = Modifier.height(4.dp))

            AddCardTextField(
                isFocused = goalFocused,
                text = goal,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                placeholderText = "5",
                labelText = "Meta",
                hasError = goalError,
                errorText = "Porcentagem inválida. Certifique-se de digitar um número entre 0.01 e 100%.",
                tipsText = "Quantos % da ação você deseja ter na sua carteira de investimentos?",
                onFocusRequestChanged = { goalFocused = it },
                onTextChanged = {
                    val text = it.replace(",", ".")
                    if (text.isEmpty()) goal = text
                    if (text.matches(validDecimalregex)) goal = text
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                when (addAssetState.state) {
                    is RequestState.Error -> {
                        AddCardButton(
                            onClick = {
                                codeError = code.isBlank()
                                unitsError = units.isBlank()
                                goalError =
                                    goal.isBlank() || goal.toDouble() <= 0.00 || goal.toDouble() > 100

                                if (codeError || unitsError || goalError)
                                    return@AddCardButton

                                onAdd(code, units.toDouble(), goal.toDouble())
                            },
                            text = "Tentar novamente",
                            buttonColor = RebalanceColors.secondaryColor,
                            errorText = addAssetState.state.resultError.message
                        )
                    }
                    is RequestState.Loading -> {
                        AddCardButton(
                            enabled = false,
                            onClick = {},
                            text = "Analisando...",
                            buttonColor = RebalanceColors.secondaryColor,
                        )
                    }
                    is RequestState.Success -> onCancel()
                    is RequestState.Undefined -> {
                        AddCardButton(
                            onClick = {
                                codeError = code.isBlank()
                                unitsError = units.isBlank()
                                goalError =
                                    goal.isBlank() || goal.toDouble() <= 0.00 || goal.toDouble() > 100

                                if (codeError || unitsError || goalError)
                                    return@AddCardButton

                                onAdd(code, units.toDouble(), goal.toDouble())
                            },
                            text = "Adicionar",
                            buttonColor = RebalanceColors.secondaryColor,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AddCardButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    buttonColor: Color,
    text: String,
    errorText: String = "",
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = errorText,
            color = RebalanceColors.secondaryColor,
            style = ReBalanceTypography.Strong3,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(4.dp))

        Button(
            enabled = enabled,
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 2.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor
            ),
            shape = RoundedCornerShape(20),

            ) {
            Text(
                modifier = Modifier.padding(4.dp),
                text = text,
                color = RebalanceColors.whiteColor,
                style = ReBalanceTypography.Strong3.copy(
                    textAlign = TextAlign.Start
                ),
            )
        }
    }
}

@Composable
private fun AddCardTextField(
    isFocused: Boolean,
    text: String,
    placeholderText: String,
    labelText: String,
    hasError: Boolean,
    errorText: String,
    keyboardOptions: KeyboardOptions,
    tipsText: String,
    onFocusRequestChanged: (isFocused: Boolean) -> Unit,
    onTextChanged: (text: String) -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier
            .onFocusChanged {
                onFocusRequestChanged(it.isFocused)
            },
        value = text,
        onValueChange = {
            onTextChanged(it)
        },
        isError = hasError,
        placeholder = {
            Text(
                placeholderText,
                color = RebalanceColors.blackColor.copy(alpha = 0.3f),
                style = ReBalanceTypography.Strong3,
            )
        },
        label = {
            Text(
                labelText,
                color = RebalanceColors.blackColor.copy(alpha = 0.8f),
                style = ReBalanceTypography.Strong3,
            )
        },
        singleLine = true,
        textStyle = ReBalanceTypography.Strong3,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            errorCursorColor = RebalanceColors.secondaryColor,
            errorBorderColor = RebalanceColors.secondaryColor,
            containerColor = RebalanceColors.whiteColor,
            unfocusedBorderColor = RebalanceColors.greyColor,
            focusedBorderColor = RebalanceColors.primaryColor,
            cursorColor = RebalanceColors.blackColor,
            textColor = RebalanceColors.blackColor
        )
    )

    if (hasError) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = errorText,
            color = RebalanceColors.secondaryColor,
            style = ReBalanceTypography.Body2,
        )
    } else {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = tipsText,
            color = getFocusedColor(isFocused),
            style = getFocusedStyle(isFocused),
        )
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
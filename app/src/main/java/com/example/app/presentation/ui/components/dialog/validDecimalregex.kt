package com.example.app.presentation.ui.components.dialog

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.presentation.theme.Colors
import com.example.app.presentation.theme.ThemeTypography
import com.example.rebalancear.presentation.states.AddAssetState
import com.example.rebalancear.presentation.states.base.RequestState
import com.example.rebalancear.presentation.states.base.VisibleState


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
                .background(color = Colors.blackColor.copy(alpha = 0.85f))
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
                        .background(Colors.whiteColor, RoundedCornerShape(20.dp))
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
        colors = CardDefaults.cardColors(Colors.whiteColor),
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
                            buttonColor = Colors.pinkColor,
                            errorText = addAssetState.state.errorMessage.message
                        )
                    }
                    is RequestState.Loading -> {
                        AddCardButton(
                            enabled = false,
                            onClick = {},
                            text = "Analisando...",
                            buttonColor = Colors.pinkColor,
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
                            buttonColor = Colors.pinkColor,
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
            color = Colors.pinkColor,
            style = ThemeTypography.roboto.strong18,
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
                color = Colors.whiteColor,
                style =  ThemeTypography.roboto.strong18.copy(
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
                color = Colors.blackColor.copy(alpha = 0.3f),
                style =  ThemeTypography.roboto.strong18,
            )
        },
        label = {
            Text(
                labelText,
                color = Colors.blackColor.copy(alpha = 0.8f),
                style = ThemeTypography.roboto.strong18,
            )
        },
        singleLine = true,
        textStyle =  ThemeTypography.roboto.strong18,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            errorCursorColor = Colors.pinkColor,
            errorBorderColor = Colors.pinkColor,
            containerColor = Colors.whiteColor,
            unfocusedBorderColor = Colors.greyColor,
            focusedBorderColor = Colors.blackColor,
            cursorColor = Colors.blackColor,
            textColor = Colors.blackColor
        )
    )

    if (hasError) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = errorText,
            color = Colors.pinkColor,
            style =  ThemeTypography.roboto.strong16,
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
        Colors.blackColor
    else
        Colors.blackColor.copy(alpha = 0.3f)
}

private fun getFocusedStyle(isFocus: Boolean): TextStyle {
    return if (isFocus)
        ThemeTypography.roboto.body16
    else
        ThemeTypography.roboto.body18
}


@Composable
@Preview
internal fun PreviewAddWalletAssetDialog() {
    AddWalletAssetDialog(
        addAssetState = AddAssetState(visibility = VisibleState.Show),
        onAdd = {_,_,_ ->

        },
        onCancel = {

        }
    )
}

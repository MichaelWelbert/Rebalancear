package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.Colors

@Composable
internal fun EditAssetDialog(
    modifier: Modifier = Modifier,
    enable: Boolean,
    currentUnits: Double,
    currentGoal: Double,
    onEdit: (units: Double, goal: Double) -> Unit,
    onCancel: () -> Unit
) {
    if (enable) {
        Box(modifier = modifier
            .fillMaxSize()
            .background(color = Colors.blackColor.copy(alpha = 0.5f))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onCancel() }) {
            DialogWalletAsset(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .background(Colors.whiteColor, RoundedCornerShape(20.dp))
                    .align(Alignment.Center),
                currentUnits = currentUnits,
                currentGoal = currentGoal,
                onEdit = onEdit,
                onCancel = onCancel,
            )
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DialogWalletAsset(
    modifier: Modifier = Modifier,
    currentUnits: Double,
    currentGoal: Double,
    onEdit: (units: Double, goal: Double) -> Unit,
    onCancel: () -> Unit,
) {
    var units by remember { mutableStateOf(currentUnits.toString()) }
    var goal by remember { mutableStateOf(currentGoal.toString()) }

    var unitsError by remember { mutableStateOf(false) }
    var goalError by remember { mutableStateOf(false) }

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(Colors.whiteColor),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp),

        ) {
        Column(modifier = Modifier.padding(32.dp)) {

            OutlinedTextField(
                modifier = Modifier,
                value = units,
                onValueChange = { units = it },
                isError = unitsError,
                label = {
                    Text(
                        "Quantidade",
                        color = Colors.blackColor.copy(alpha = 0.8f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                placeholder = {
                    Text(
                        "10",
                        color = Colors.blackColor.copy(alpha = 0.3f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                singleLine = true,
                textStyle = ReBalanceTypography.Strong3,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    errorCursorColor = Colors.secondaryColor,
                    errorBorderColor = Colors.secondaryColor,
                    containerColor = Colors.whiteColor,
                    unfocusedBorderColor = Colors.greyColor,
                    focusedBorderColor = Colors.primaryColor,
                    cursorColor = Colors.blackColor,
                    textColor = Colors.blackColor
                )
            )

            if (unitsError) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Quantidade inválida. Por favor, informe a quantidade de ações que você possui.",
                    color = Colors.secondaryColor,
                    style = ReBalanceTypography.Body2,
                )
            } else {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Quantas ações você possui desse ativo?",
                    color = Colors.blackColor.copy(alpha = 0.3f),
                    style = ReBalanceTypography.Body2,
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
                        color = Colors.blackColor.copy(alpha = 0.3f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                label = {
                    Text(
                        "Meta",
                        color = Colors.blackColor.copy(alpha = 0.8f),
                        style = ReBalanceTypography.Strong3,
                    )
                },
                singleLine = true,
                textStyle = ReBalanceTypography.Strong3,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    errorCursorColor = Colors.secondaryColor,
                    errorBorderColor = Colors.secondaryColor,
                    containerColor = Colors.whiteColor,
                    unfocusedBorderColor = Colors.greyColor,
                    focusedBorderColor = Colors.primaryColor,
                    cursorColor = Colors.blackColor,
                    textColor = Colors.blackColor
                )
            )

            if (goalError) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Porcentagem inválida. Certifique-se de digitar um número entre 0 e 100%.",
                    color = Colors.secondaryColor,
                    style = ReBalanceTypography.Body2,
                )
            } else {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Quantos % da ação você deseja ter na sua carteira de investimentos?",
                    color = Colors.blackColor.copy(alpha = 0.3f),
                    style = ReBalanceTypography.Body2,
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        if (units.isBlank())
                            unitsError = true

                        if (goal.isBlank())
                            goalError = true

                        if (unitsError || goalError)
                            return@Button

                        onEdit(units.toDouble(), goal.toDouble())
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, false),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 2.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Colors.secondaryColor
                    ),
                    shape = RoundedCornerShape(20),

                    ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "Editar",
                        color = Colors.whiteColor,
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
                        containerColor = Colors.primaryColor
                    ),
                    shape = RoundedCornerShape(20),

                    ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "Cancelar",
                        color = Colors.whiteColor,
                        style = ReBalanceTypography.Strong3.copy(
                            textAlign = TextAlign.Start
                        ),
                    )
                }
            }
        }
    }
}
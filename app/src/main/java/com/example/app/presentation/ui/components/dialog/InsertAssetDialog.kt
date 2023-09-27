package com.example.app.presentation.ui.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.app.core.strings.Strings
import com.example.app.presentation.presenter.AddAssetPresenter
import com.example.app.presentation.states.AddAssetState
import com.example.app.presentation.theme.Colors
import com.example.rebalancear.R

@Composable
fun InsertAssetDialog(
    state: AddAssetState,
    onChangeState: (nextState: AddAssetState) -> Unit,
    onConfirm: (data: AddAssetPresenter) -> Unit,
    onCancel: () -> Unit,
) {
    var assetError by remember { mutableStateOf("") }
    var unitsError by remember { mutableStateOf("") }
    var goalError by remember { mutableStateOf("") }

    OutSideCard(
        onCancel = onCancel,
    ) {
        when (state) {
            AddAssetState.Hide -> Unit
            is AddAssetState.InsertAsset -> {
                AddAssetCard(
                    message = Strings.WalletAddAssetInsertAssetMessage,
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters),
                    image = R.drawable.mascot_female_assets,
                    errorMessage = assetError,
                    buttonText = Strings.WalletAddAssetContinue,
                    textFieldPlaceHolder = Strings.WalletAddAssetInsertAssetTextFieldPlaceHolder,
                    onConfirm = { code ->
                        if(code== "") {
                            assetError = "Você não digitou o código! Digite um código, exemplo: BOVA11"
                            return@AddAssetCard
                        }
                        val data = state.data.copy(code = code)
                        onChangeState(AddAssetState.InsertUnits(data))
                    },
                    onBack = {
                        onChangeState(AddAssetState.Hide)
                    }
                )
            }

            is AddAssetState.InsertUnits -> {
                AddAssetCard(
                    message = Strings.WalletAddAssetInsertUnitsMessage,
                    enableBackButton = true,
                    image = R.drawable.mascot_female_units,
                    errorMessage = unitsError,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    buttonText = Strings.WalletAddAssetContinue,
                    textFieldPlaceHolder = Strings.WalletAddAssetInsertUnitsTextFieldPlaceHolder,
                    onConfirm = { units ->
                        val data = state.data.copy(units = units.toFloat())
                        onChangeState(AddAssetState.InsertGoal(data))
                    },
                    onBack = {
                        val data = state.data
                        onChangeState(AddAssetState.InsertAsset(data))
                    }
                )
            }

            is AddAssetState.InsertGoal -> {
                AddAssetCard(
                    message = Strings.WalletAddAssetInsertGoalMessage,
                    enableBackButton = true,
                    image = R.drawable.mascot_female_goals,
                    errorMessage = goalError,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    buttonText = Strings.WalletAddAssetConfirm,
                    textFieldPlaceHolder = Strings.WalletAddAssetInsertGoalTextFieldPlaceHolder,
                    onConfirm = { goal ->
                        val data = state.data.copy(goal = goal.toFloat())
                        onConfirm(data)
                        onChangeState(AddAssetState.Hide)
                    },
                    onBack = {
                        val data = state.data
                        onChangeState(AddAssetState.InsertUnits(data))
                    }
                )
            }
        }

    }
}

@Composable
private fun OutSideCard(
    onCancel: () -> Unit,
    content: @Composable() (BoxScope.() -> Unit)
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Colors.blackColor.copy(alpha = 0.85f))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                onCancel()
            },
        content = content
    )
}


@Composable
@Preview
fun InsertCodeDialogPreview() {
    InsertAssetDialog(
        state = AddAssetState.InsertAsset(data = AddAssetPresenter()),
        onChangeState = {},
        onCancel = {},
        onConfirm = {}
    )
}
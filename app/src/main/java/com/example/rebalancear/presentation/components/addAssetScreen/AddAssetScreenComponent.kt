package com.example.rebalancear.presentation.components.addAssetScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.presentation.components.shared.GradientButtonComponent
import com.example.rebalancear.presentation.components.shared.RebalanceTextFieldComponent
import com.example.rebalancear.presentation.components.shared.SearchingBarComponent
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors


@Composable
fun AddAssetScreenComponent() {
    var goalFieldState by remember {
        mutableStateOf("")
    }

    var assetUnitFieldState by remember {
        mutableStateOf("")
    }

    var assetPriceFieldState by remember {
        mutableStateOf("")
    }

    var searchFieldState by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        RebalanceColors.darkGrey,
                        RebalanceColors.lightGrey,
                    ),
                )
            )
            .padding(36.dp),
    ) {

        Column {
            SearchingBarComponent(
                placeholderText = "BBAS3",
                textFieldValue = searchFieldState,
                onTextFieldChanged = { text ->
                    searchFieldState = text
                },
                onClickSearch = {}
            )

            Spacer(modifier = Modifier.height(36.dp))

            if (searchFieldState == "BBAS3") {
                RebalanceTextFieldComponent(
                    placeholderText = "8",
                    noTextInputMessage = "Qual a porcentagem você desejá ter de $searchFieldState?",
                    filledTextInputMessage = "Vocẽ deseja ter $goalFieldState% de $searchFieldState",
                    textFieldValue = goalFieldState,
                    onTextFieldChanged = { text ->
                        goalFieldState = text
                    }
                )

                Spacer(modifier = Modifier.height(28.dp))

                RebalanceTextFieldComponent(
                    placeholderText = "12",
                    noTextInputMessage = "Quantas unidades você comprou?",
                    filledTextInputMessage = "Você comprou $assetUnitFieldState unidades",
                    textFieldValue = assetUnitFieldState,
                    onTextFieldChanged = { text ->
                        assetUnitFieldState = text
                    }
                )

                Spacer(modifier = Modifier.height(28.dp))

                RebalanceTextFieldComponent(
                    placeholderText = "32,50",
                    noTextInputMessage = "Qual valor você pagou por cada unidade?",
                    filledTextInputMessage = "Vocẽ pagou R$$assetPriceFieldState por cada unidade",
                    textFieldValue = assetPriceFieldState,
                    onTextFieldChanged = { text ->
                        assetPriceFieldState = text
                    }
                )

                Spacer(modifier = Modifier.height(36.dp))

                if (searchFieldState.isNotBlank() && goalFieldState.isNotBlank() && assetPriceFieldState.isNotBlank() && assetUnitFieldState.isNotBlank()) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Você pretende ter $goalFieldState% da sua carteira em $searchFieldState e tem investido R$${assetPriceFieldState.toInt() * assetUnitFieldState.toInt()} nesse ativo.",
                        color = RebalanceColors.lightYellow,
                        style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                    )

                    Spacer(modifier = Modifier.height(36.dp))
                }

                GradientButtonComponent(
                    text = "Confirmar",
                    gradient = Brush.linearGradient(
                        colors = listOf(
                            RebalanceColors.darkBlue,
                            RebalanceColors.lightBlue,
                            RebalanceColors.darkBlue,
                        ),
                    ),
                )
            } else if (searchFieldState.isNotBlank()) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Procurando pelo ativo com código $searchFieldState ...",
                    color = RebalanceColors.lightYellow,
                    style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                )
            }
        }
    }
}




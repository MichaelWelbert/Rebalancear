package com.example.rebalancear.presentation.components.assetScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.R
import com.example.rebalancear.presentation.components.shared.GradientButtonComponent
import com.example.rebalancear.presentation.components.shared.RebalanceTextFieldComponent
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors

@Composable
fun AssetScreenComponent() {
    var goalFieldState by remember {
        mutableStateOf("8")
    }
    var assetUnitFieldState by remember {
        mutableStateOf("")
    }

    var assetPriceFieldState by remember {
        mutableStateOf("")
    }

    var editGoalState by remember {
        mutableStateOf(false)
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
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.width(26.dp))

                Text(
                    modifier = Modifier,
                    text = "BBAS3",
                    color = RebalanceColors.white,
                    style = ReBalanceTypography.Strong5.copy(textAlign = TextAlign.Center),
                )

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .shadow(elevation = 2.dp, RoundedCornerShape(20.dp))
                        .background(color = RebalanceColors.darkRed)
                        .clickable {

                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.ic_delete),
                        contentDescription = null,
                        tint = RebalanceColors.lightRed
                    )
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

            if (editGoalState) {
                Box(modifier = Modifier) {
                    RebalanceTextFieldComponent(
                        placeholderText = "8",
                        noTextInputMessage = "Qual a porcentagem você desejá ter de BBAS3",
                        filledTextInputMessage = "Vocẽ deseja ter $goalFieldState% de BBAS3",
                        textFieldValue = goalFieldState,
                        onTextFieldChanged = { text ->
                            goalFieldState = text
                        }
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))
            } else {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Seu objetivo é $goalFieldState% em bbas3",
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong4.copy(textAlign = TextAlign.Center),
                    )

                    Spacer(modifier = Modifier.width(16.dp))


                    Box(
                        modifier = Modifier
                            .size(26.dp)
                            .shadow(elevation = 2.dp, RoundedCornerShape(20.dp))
                            .background(color = RebalanceColors.darkBlue)
                            .clickable {
                                editGoalState = true
                            },
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(id = R.drawable.ic_edit),
                            contentDescription = null,
                            tint = RebalanceColors.lightOceanBlue
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Você precisa investir R$245 para atingir o objetivo.",
                    color = RebalanceColors.lightYellow,
                    style = ReBalanceTypography.Strong2.copy(textAlign = TextAlign.Center),
                )

                Spacer(modifier = Modifier.height(36.dp))

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

                if (goalFieldState.isNotBlank() && assetPriceFieldState.isNotBlank() && assetUnitFieldState.isNotBlank()) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Você está investindo R$${assetPriceFieldState.toInt() * assetUnitFieldState.toInt()} nesse ativo.",
                        color = RebalanceColors.lightYellow,
                        style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                    )

                    Spacer(modifier = Modifier.height(36.dp))
                }
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
                onClick = {
                    if(editGoalState)
                        editGoalState = false
                }
            )
        }
    }
}
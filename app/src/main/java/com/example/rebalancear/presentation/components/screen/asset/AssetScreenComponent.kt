package com.example.rebalancear.presentation.components.screen.asset

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rebalancear.R
import com.example.rebalancear.presentation.components.shared.ActionCardComponent
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors


@OptIn(ExperimentalMaterial3Api::class)
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

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f),
                            text = "BBAS3",
                            color = RebalanceColors.white,
                            style = ReBalanceTypography.Tittle,
                            textAlign = TextAlign.Start
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                modifier = Modifier,
                                text = "5% ",
                                color = RebalanceColors.lightRed,
                                style = ReBalanceTypography.Tittle.copy(fontSize = 14.sp),
                                textAlign = TextAlign.End
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                modifier = Modifier,
                                text = "8%",
                                color = RebalanceColors.white,
                                style = ReBalanceTypography.Tittle.copy(fontSize = 16.sp),
                                textAlign = TextAlign.End
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            "backIcon",
                            tint = RebalanceColors.white
                        )
                    }
                },

                backgroundColor = RebalanceColors.darkGrey,
                elevation = 10.dp
            )
        },

        content = { innerPadding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(RebalanceColors.darkGrey)
                    .padding(28.dp),
            ) {
                LazyColumn {
                    item {
                        ActionCardComponent(
                            title = "COMPRAR",
                            subtitle = "Quer comprar algumas unidades do seu ativo? Faça isso por aqui!",
                            icon = R.drawable.ic_add_circle,
                            colors = listOf(
                                RebalanceColors.darkOceanBlue,
                                RebalanceColors.lightOceanBlue
                            ),
                            onClick = {}
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        ActionCardComponent(
                            title = "VENDER",
                            subtitle = "Quer vender algumas unidades do seu ativo? Faça isso por aqui!",
                            icon = R.drawable.ic_remove_circle,
                            colors = listOf(
                                RebalanceColors.darkRed,
                                RebalanceColors.lightRed
                            ),
                            onClick = {}
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        ActionCardComponent(
                            title = "HISTÓRICO",
                            subtitle = "Deseja ver o historico de compra desse ativo? Faça isso por aqui!",
                            icon = R.drawable.ic_record,
                            colors = listOf(
                                RebalanceColors.darkYellow,
                                RebalanceColors.lightYellow
                            ),
                            onClick = {}
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        ActionCardComponent(
                            title = "EDITAR",
                            subtitle = "Deseja editar seu objetivo esse ativo? Faça isso por aqui!",
                            icon = R.drawable.ic_edit,
                            colors = listOf(
                                RebalanceColors.darkGreen,
                                RebalanceColors.lightGreen
                            ),
                            onClick = {}
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        ActionCardComponent(
                            title = "EXCLUIR",
                            subtitle = "Deseja excluir seu objetivo esse ativo? Faça isso por aqui!",
                            icon = R.drawable.ic_delete,
                            colors = listOf(
                                RebalanceColors.darkGrey,
                                RebalanceColors.lightGrey
                            ),
                            onClick = {}
                        )

                        Spacer(modifier = Modifier.height(20.dp))
                    }


                    /*    LazyColumn {
                    items(12) {
                        Spacer(modifier = Modifier.height(12.dp))
                        RecordAssetComponent(
                            WalletAssetPresenter(
                                code = "BBAS3",
                                assetType = AssetTypes.STOCKS,
                                investedAmount = 25000f,
                                percentageGoal = 5f,
                                percentageOwned = 2f,
                                contributeState = ContributeState.CONTRIBUTE
                            ),
                            recordType = RecordType.BUY
                        )

                    }
                }

             */
                }
            }
        })
}

/*
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
                            if (editGoalState)
                                editGoalState = false
                        }
                    )

                    Spacer(modifier = Modifier.height(36.dp))
 */
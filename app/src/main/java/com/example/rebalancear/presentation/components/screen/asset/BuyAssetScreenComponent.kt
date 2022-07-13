package com.example.rebalancear.presentation.components.screen.asset

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rebalancear.R
import com.example.rebalancear.presentation.components.shared.BuyCardComponent
import com.example.rebalancear.presentation.components.shared.GradientButtonComponent
import com.example.rebalancear.presentation.components.shared.RebalanceTextFieldComponent
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyAssetScreenComponent(
    navController: NavController
) {

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
                        verticalAlignment = Alignment.Bottom

                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "Comprar",
                            color = RebalanceColors.white,
                            style = ReBalanceTypography.Tittle,
                            textAlign = TextAlign.Start
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        androidx.compose.material3.Icon(
                            Icons.Filled.ArrowBack,
                            "backIcon",
                            tint = RebalanceColors.white
                        )
                    }
                },

                backgroundColor = RebalanceColors.strongDarkBlue,
                elevation = 10.dp
            )
        },

        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(RebalanceColors.strongDarkBlue)
                    .padding(16.dp),
            ) {

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Quantas unidades você comprou?",
                    color = RebalanceColors.lightGrey,
                    style = ReBalanceTypography.Strong2.copy(textAlign = TextAlign.Start),
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = assetUnitFieldState,
                    onValueChange = { assetUnitFieldState = it },
                    maxLines = 1,
                    textStyle = ReBalanceTypography.Strong2.copy(textAlign = TextAlign.Start),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = RebalanceColors.strongLightBlue,
                        textColor = if (assetPriceFieldState.isBlank()) RebalanceColors.lightGrey else RebalanceColors.white
                    )
                )


                Spacer(modifier = Modifier.height(24.dp))


                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Qual valor você pagou por cada unidade?",
                    color = RebalanceColors.lightGrey,
                    style = ReBalanceTypography.Strong2.copy(textAlign = TextAlign.Start),
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = assetPriceFieldState,
                    onValueChange = { assetPriceFieldState = it },
                    maxLines = 1,
                    textStyle = ReBalanceTypography.Strong2.copy(textAlign = TextAlign.Start),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = RebalanceColors.strongLightBlue,
                        textColor = if (assetPriceFieldState.isBlank()) RebalanceColors.lightGrey else RebalanceColors.white
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))


                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = if (goalFieldState.isNotBlank() && assetPriceFieldState.isNotBlank() && assetUnitFieldState.isNotBlank())
                        "Você precisa investir R\$245 para atingir o objetivo. \n" +
                            "Você está investindo R$${assetPriceFieldState.toInt() * assetUnitFieldState.toInt()} nesse ativo." else "Você precisa investir R\$245 para atingir o objetivo.",
                    color = RebalanceColors.lightYellow,
                    style = ReBalanceTypography.Strong2.copy(textAlign = TextAlign.Center),
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { editGoalState = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(horizontal = 32.dp),

                    ) {
                    Text(
                        modifier = Modifier.padding(12.dp),
                        text = "Comprar",
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong4.copy(textAlign = TextAlign.Start),
                    )
                }

                Spacer(modifier = Modifier.height(36.dp))
            }
        })
}
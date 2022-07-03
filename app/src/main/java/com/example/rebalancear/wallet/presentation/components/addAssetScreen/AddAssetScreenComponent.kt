package com.example.rebalancear.wallet.presentation.components.addAssetScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*

import androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox
import androidx.compose.material3.TextFieldDefaults.indicatorLine

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.R
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAssetScreen() {
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
            ),
    ) {
        Column() {
            var textFieldState by remember {
                mutableStateOf("")
            }

            var goalFieldState by remember {
                mutableStateOf("")
            }

            var assetUnitFieldState by remember {
                mutableStateOf("")
            }

            var assetPriceFieldState by remember {
                mutableStateOf("")
            }

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 36.dp,
                        end = 36.dp,
                        top = 48.dp
                    )
                    .clip(RoundedCornerShape(36.dp)),
                value = textFieldState,
                onValueChange = {
                    textFieldState = it.uppercase()
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier.clickable {

                        },
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text(
                        text = "Digite o código do ativo",
                        color = RebalanceColors.lightGrey.copy(alpha = 0.3f),
                        style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    placeholderColor = RebalanceColors.darkRed,
                    cursorColor = RebalanceColors.lightGrey,
                    containerColor = RebalanceColors.white,
                    focusedIndicatorColor = RebalanceColors.lightGrey,
                    textColor = RebalanceColors.lightGrey
                ),

                enabled = true,
                singleLine = true,
                readOnly = false,
                maxLines = 1,
                textStyle = ReBalanceTypography.Strong3
            )


            Row(
                modifier = Modifier.padding(top = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.4f)
                        .padding(
                            start = 36.dp,
                            end = 18.dp,
                            top = 12.dp
                        )
                        .clip(RoundedCornerShape(36.dp)),
                    value = goalFieldState,
                    onValueChange = {
                        goalFieldState = it.uppercase()
                    },
                    placeholder = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "8",
                            color = RebalanceColors.lightGrey.copy(alpha = 0.3f),
                            style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        placeholderColor = RebalanceColors.darkRed,
                        cursorColor = RebalanceColors.lightGrey,
                        containerColor = RebalanceColors.white,
                        focusedIndicatorColor = RebalanceColors.lightGrey,
                        textColor = RebalanceColors.lightGrey
                    ),

                    enabled = true,
                    singleLine = true,
                    readOnly = false,
                    maxLines = 1,
                    textStyle = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),

                    )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.6f)
                        .padding(
                            end = 36.dp,
                            top = 12.dp
                        )
                        .clip(RoundedCornerShape(12.dp)),
                    text = if (goalFieldState.isBlank())
                        "Qual a porcentagem você desejá ter desse ativo?"
                    else "Vocẽ deseja ter $goalFieldState% desse ativo!!",
                    color = RebalanceColors.white,
                    style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                )

            }

            Row(
                modifier = Modifier.padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.4f)
                        .padding(
                            start = 36.dp,
                            end = 18.dp,
                            top = 12.dp
                        )
                        .clip(RoundedCornerShape(28.dp)),
                    value = assetUnitFieldState,
                    onValueChange = {
                        assetUnitFieldState = it.uppercase()
                    },
                    placeholder = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "12",
                            color = RebalanceColors.lightGrey.copy(alpha = 0.3f),
                            style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        placeholderColor = RebalanceColors.darkRed,
                        cursorColor = RebalanceColors.lightGrey,
                        containerColor = RebalanceColors.white,
                        focusedIndicatorColor = RebalanceColors.lightGrey,
                        textColor = RebalanceColors.lightGrey
                    ),

                    enabled = true,
                    singleLine = true,
                    readOnly = false,
                    maxLines = 1,
                    textStyle = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.6f)
                        .padding(
                            end = 36.dp,
                            top = 12.dp
                        )
                        .clip(RoundedCornerShape(12.dp)),
                    text = if (assetUnitFieldState.isBlank())
                        "Quantas unidades desse ativo você comprou?"
                    else "Você comprou $assetUnitFieldState unidades desse ativo!!",
                    color = RebalanceColors.white,
                    style = ReBalanceTypography.Strong3,
                    textAlign = TextAlign.Center
                )
            }

            Row(
                modifier = Modifier.padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.4f)
                        .padding(
                            start = 36.dp,
                            end = 18.dp,
                            top = 12.dp
                        )
                        .clip(RoundedCornerShape(28.dp)),
                    value = assetPriceFieldState,
                    onValueChange = {
                        assetPriceFieldState = it.uppercase()
                    },
                    placeholder = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "32,50",
                            color = RebalanceColors.lightGrey.copy(alpha = 0.3f),
                            style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        placeholderColor = RebalanceColors.darkRed,
                        cursorColor = RebalanceColors.lightGrey,
                        containerColor = RebalanceColors.white,
                        focusedIndicatorColor = RebalanceColors.lightGrey,
                        textColor = RebalanceColors.lightGrey
                    ),

                    enabled = true,
                    singleLine = true,
                    readOnly = false,
                    maxLines = 1,
                    textStyle = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center)
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.6f)
                        .padding(
                            end = 36.dp,
                            top = 12.dp
                        )
                        .clip(RoundedCornerShape(28.dp)),
                    text = if (assetPriceFieldState.isBlank())
                        "Qual valor você pagou por cada unidades desse ativo?"
                    else "Vocẽ pagou R$$assetPriceFieldState por cada unidade desse ativo!!",
                    color = RebalanceColors.white,
                    style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                )
            }
            if (goalFieldState.isNotBlank() && assetPriceFieldState.isNotBlank() && assetUnitFieldState.isNotBlank()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 36.dp,
                            end = 36.dp,
                            top = 28.dp,
                        ),
                    text = "Você pretende ter $goalFieldState% da sua carteira nesse ativo e investiu R$${assetPriceFieldState.toInt() * assetUnitFieldState.toInt()} ...",
                    color = RebalanceColors.lightYellow,
                    style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                )
            }

            Row(
                modifier = Modifier
                    .padding(
                        start = 36.dp,
                        end = 36.dp,
                        top = 28.dp,
                    )
                    .fillMaxWidth(),

                ) {

                Button(modifier = Modifier.padding(12.dp),

                    onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = RebalanceColors.darkBlue
                )) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        text = "Confirmar",
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                    )
                }
            }
        }
    }
}


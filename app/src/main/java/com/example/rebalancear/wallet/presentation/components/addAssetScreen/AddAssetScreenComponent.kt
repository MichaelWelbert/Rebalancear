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

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 36.dp,
                        end = 36.dp,
                        top = 48.dp
                    )
                    .clip(RoundedCornerShape(12.dp)),
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
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong2,
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    placeholderColor = RebalanceColors.darkRed,
                    cursorColor = RebalanceColors.lightBlue,
                    containerColor = RebalanceColors.darkBlue,
                    focusedIndicatorColor = RebalanceColors.lightBlue,
                    textColor = RebalanceColors.white
                ),

                enabled = true,
                singleLine = true,
                readOnly = false,
                maxLines = 1,
                textStyle = ReBalanceTypography.Strong2
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                text = "Banco do Brasil",
                color = RebalanceColors.white,
                style = ReBalanceTypography.Strong5,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                text = "Cotação 32,50",
                color = RebalanceColors.white,
                style = ReBalanceTypography.Strong5,
                textAlign = TextAlign.Center
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f)
                        .padding(
                            start = 36.dp,
                            end = 18.dp,
                            top = 12.dp
                        )
                        .clip(RoundedCornerShape(12.dp)),
                    value = goalFieldState,
                    onValueChange = {
                        goalFieldState = it.uppercase()
                    },
                    placeholder = {
                        Text(
                            text = "Objetivo",
                            color = RebalanceColors.white,
                            style = ReBalanceTypography.Strong2,
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        placeholderColor = RebalanceColors.darkRed,
                        cursorColor = RebalanceColors.lightBlue,
                        containerColor = RebalanceColors.darkBlue,
                        focusedIndicatorColor = RebalanceColors.lightBlue,
                        textColor = RebalanceColors.white
                    ),

                    enabled = true,
                    singleLine = true,
                    readOnly = false,
                    maxLines = 1,
                    textStyle = ReBalanceTypography.Strong2
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f)
                        .padding(
                            end = 36.dp,
                            top = 12.dp
                        )
                        .clip(RoundedCornerShape(12.dp)),
                    text = if(goalFieldState.isBlank())
                        "Qual a porcentagem você desejá ter desse ativo?"
                    else "Vocẽ deseja ter $goalFieldState% desse ativo!!",
                    color = RebalanceColors.white,
                    style = ReBalanceTypography.Strong2,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
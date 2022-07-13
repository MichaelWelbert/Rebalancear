package com.example.rebalancear.presentation.components.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors

@Composable
fun BuyCardComponent(
    title: String,
    unitText: String,
    priceText: String,
    onClick: () -> Unit,
    icon: Int,
    colors: List<Color>
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

    Box(
        modifier = Modifier
            .clickable { onClick() }
            .shadow(2.dp, RoundedCornerShape(20.dp))
            .background(
                Brush.verticalGradient(colors = colors),
            )

    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title.uppercase(),
                    color = RebalanceColors.white,
                    style = ReBalanceTypography.Strong5.copy(textAlign = TextAlign.Start),
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.75f)
                            .padding(end = 16.dp),
                        text = unitText,
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Body3.copy(textAlign = TextAlign.Start),
                    )

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.25f)
                            .clip(RoundedCornerShape(28.dp)),
                        value = "",
                        onValueChange = {

                        },
                        placeholder = {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "10",
                                color = RebalanceColors.white.copy(alpha = 0.3f),
                                style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = RebalanceColors.white,
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = RebalanceColors.white,
                            textColor = RebalanceColors.white,
                            disabledIndicatorColor = RebalanceColors.white,
                            focusedLabelColor = RebalanceColors.white,
                            unfocusedIndicatorColor = RebalanceColors.white,
                            unfocusedLabelColor = RebalanceColors.white,
                        ),

                        enabled = true,
                        singleLine = true,
                        maxLines = 1,
                        textStyle = ReBalanceTypography.Strong2.copy(textAlign = TextAlign.Center)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.75f)
                            .padding(end = 16.dp),
                        text = priceText,
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Body3.copy(textAlign = TextAlign.Start),
                    )

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.25f)
                            .clip(RoundedCornerShape(28.dp)),
                        value = "",
                        onValueChange = {

                        },
                        placeholder = {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "10",
                                color = RebalanceColors.white.copy(alpha = 0.3f),
                                style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = RebalanceColors.white,
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = RebalanceColors.white,
                            textColor = RebalanceColors.white,
                            disabledIndicatorColor = RebalanceColors.white,
                            focusedLabelColor = RebalanceColors.white,
                            unfocusedIndicatorColor = RebalanceColors.white,
                            unfocusedLabelColor = RebalanceColors.white,
                        ),

                        enabled = true,
                        singleLine = true,
                        maxLines = 1,
                        textStyle = ReBalanceTypography.Strong2.copy(textAlign = TextAlign.Center)
                    )
                }

                Spacer(modifier = Modifier.height(36.dp))


                androidx.compose.material.Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = if (goalFieldState.isNotBlank() && assetPriceFieldState.isNotBlank() && assetUnitFieldState.isNotBlank())
                        "Você precisa investir R\$245 para atingir o objetivo. \n" +
                            "Você está investindo R$${assetPriceFieldState.toInt() * assetUnitFieldState.toInt()} nesse ativo." else "Você precisa investir R\$245 para atingir o objetivo.",
                    color = RebalanceColors.lightYellow,
                    style = ReBalanceTypography.Strong2.copy(textAlign = TextAlign.Center),
                )


                Spacer(modifier = Modifier.height(36.dp))
            }
        }
    }
}
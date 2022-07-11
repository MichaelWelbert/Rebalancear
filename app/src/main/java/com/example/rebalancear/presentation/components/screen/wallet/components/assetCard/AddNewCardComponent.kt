package com.example.rebalancear.presentation.components.screen.wallet.components.assetCard


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rebalancear.R
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors
import com.example.rebalancear.routes.Routes


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddNewCardComponent(
    navController: NavController,
) {
    androidx.compose.material.Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                end = 16.dp,
                start = 16.dp,
            ),
        elevation = 2.dp,
        shape = RoundedCornerShape(12),
        onClick = {
             navController.navigate(Routes.AddAssetScreen.route)
        }
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            RebalanceColors.white,
                            RebalanceColors.white
                        ),
                    ),
                )

        ) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.75f)
                        .padding(start = 8.dp)
                ) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "ADICIONAR",
                        color = RebalanceColors.darkGrey,
                        style = ReBalanceTypography.Strong5.copy(textAlign = TextAlign.Start),
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp),
                        text = "Adicione um novo ativo a sua lista de ativos!",
                        color = RebalanceColors.darkGrey,
                        style = ReBalanceTypography.Body2.copy(textAlign = TextAlign.Start),
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                }

                Box(
                    modifier = Modifier.weight(0.25f),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .size(56.dp)
                            .fillMaxWidth(),
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = null,
                        tint = RebalanceColors.darkGrey.copy(alpha = 0.7f)
                    )
                }

            }

        }
    }
}





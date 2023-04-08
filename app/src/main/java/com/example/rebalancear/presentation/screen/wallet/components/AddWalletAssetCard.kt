package com.example.rebalancear.presentation.screen.wallet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.Card as Cardx
import com.example.rebalancear.routes.Routes
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors
import com.example.rebalancear.R
import androidx.compose.material3.*
import com.example.rebalancear.core.strings.WalletScreenStrings

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun AddWalletAssetCard(
    onClick: () -> Unit,
) {

    Cardx(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                end = 16.dp,
                start = 16.dp,
            ),
        elevation = 2.dp,
        shape = RoundedCornerShape(12),
        onClick = onClick

    ) {
        CardContent()
    }
}

@Composable
private fun CardContent() {
    Box(
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        RebalanceColors.neutral0,
                        RebalanceColors.neutral0
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
                    .fillMaxWidth()
                    .weight(1f, false)
                    .padding(start = 8.dp)
            ) {
                CardTexts()
            }

            CardIcon()
        }

    }
}

@Composable
private fun CardIcon() {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(56.dp)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = null,
            tint = RebalanceColors.neutral400.copy(alpha = 0.7f)
        )
    }
}

@Composable
private fun CardTexts() {
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = WalletScreenStrings.add_wallet_asset_card_add,
        color = RebalanceColors.neutral400,
        style = ReBalanceTypography.Strong5.copy(textAlign = TextAlign.Start),
    )

    Spacer(modifier = Modifier.height(12.dp))

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        text = WalletScreenStrings.add_wallet_asset_card_add_asset,
        color = RebalanceColors.neutral400,
        style = ReBalanceTypography.Body2.copy(textAlign = TextAlign.Start),
    )

    Spacer(modifier = Modifier.height(12.dp))
}

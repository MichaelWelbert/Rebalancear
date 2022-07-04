package com.example.rebalancear.presentation.components.screen.asset.components

import android.icu.text.NumberFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rebalancear.R
import com.example.rebalancear.core.AssetTypes
import com.example.rebalancear.core.ContributeState
import com.example.rebalancear.presentation.components.screen.wallet.components.assetCard.AssetCardComponent
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.routes.Routes
import com.example.rebalancear.ui.RebalanceStrings
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RecordAssetComponent(
    asset: WalletAssetPresenter
) {
    androidx.compose.material.Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 3.dp,
        shape = RoundedCornerShape(28),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            RebalanceColors.darkGold,
                            RebalanceColors.lightGold,
                        ),
                    )
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        modifier = Modifier,
                        text = "R$ ${NumberFormat.getInstance().format(asset.investedAmount)}",
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong2,
                    )
                    Text(
                        modifier = Modifier,
                        text = RebalanceStrings.wallet_asset_invested_amount,
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong1,
                    )
                }

                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier,
                        text = "25",
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong2,
                    )
                    Text(
                        modifier = Modifier,
                        text = "unidades",
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong1,
                    )
                }

                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier,
                        text = "R$3554,20",
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong2,
                    )
                    Text(
                        modifier = Modifier,
                        text = "Preço",
                        color = RebalanceColors.white,
                        style = ReBalanceTypography.Strong1,
                    )
                }



                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .shadow(elevation = 2.dp, RoundedCornerShape(20.dp))
                        .background(color = RebalanceColors.darkBlue)
                        .clickable {

                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = null,
                        tint = RebalanceColors.white
                    )
                }
            }
        }
    }
}

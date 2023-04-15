package com.example.rebalancear.presentation.screen.asset.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.rebalancear.R
import com.example.rebalancear.core.strings.AssetScreenStrings
import com.example.rebalancear.core.strings.WalletScreenStrings
import com.example.rebalancear.domain.status.ContributeStatus
import com.example.rebalancear.presentation.presenters.AssetPresenter
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AssetPresenterCard(
    modifier: Modifier = Modifier,
    asset: AssetPresenter,
    onClickDelete: () -> Unit,
    onClickBack: () -> Unit,
) {
    val statusColor200 = getColors200(asset.contributeState)
    val statusColor100 = getColors100(asset.contributeState)
    Column {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .shadow(10.dp, clip = false)
                .zIndex(1f),
            color = RebalanceColors.neutral0,
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onClickBack
                ) {
                    Icon(
                        Icons.Filled.ArrowBack, "", tint = RebalanceColors.secondaryColor
                    )
                }

                Text(
                    text = asset.code.uppercase(),
                    color = RebalanceColors.primaryColor,
                    style = ReBalanceTypography.Tittle.copy(fontSize = 22.sp),
                    textAlign = TextAlign.End
                )


                IconButton(onClick = onClickBack) {
                    Icon(
                        Icons.Filled.MoreVert, "", tint = RebalanceColors.secondaryColor
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .zIndex(5f),
            shape = RoundedCornerShape(6.dp),
            colors = CardDefaults.cardColors(RebalanceColors.whiteColor),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)

        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(50.dp),
                            painter = painterResource(id = R.drawable.ic_goal),
                            contentDescription = null,
                            tint = RebalanceColors.greyColor
                        )

                        when(asset.contributeState) {
                            ContributeStatus.CONTRIBUTE -> {
                                Text(
                                    text = "Em busca da \n meta".uppercase(),
                                    color = RebalanceColors.rightColor,
                                    style = ReBalanceTypography.Strong2.copy(letterSpacing = 1.4.sp),
                                    textAlign = TextAlign.Center,
                                )
                            }
                            ContributeStatus.WAIT -> {
                                Text(
                                    text = "Você alcançou \n a meta".uppercase(),
                                    color = RebalanceColors.wrongColor,
                                    style = ReBalanceTypography.Strong2.copy(letterSpacing = 1.4.sp),
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }


                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                modifier = Modifier,
                                text = AssetScreenStrings.asset_info_price.uppercase(),
                                color = RebalanceColors.greyColor,
                                style = ReBalanceTypography.Body2,
                            )
                            Text(
                                text = "R$ ${String.format("%.2f", asset.investedAmount)}",
                                color = RebalanceColors.blackColor,
                                style = ReBalanceTypography.Strong3,
                            )
                            when (asset.contributeState) {
                                ContributeStatus.CONTRIBUTE -> {
                                    LinearProgressIndicator(
                                        modifier = Modifier.width(50.dp),
                                        color = RebalanceColors.rightColor,
                                        trackColor = RebalanceColors.whiteColor
                                    )
                                }
                                ContributeStatus.WAIT -> {
                                    LinearProgressIndicator(
                                        modifier = Modifier.width(50.dp),
                                        color = RebalanceColors.wrongColor,
                                        trackColor = RebalanceColors.whiteColor
                                    )
                                }
                            }
                        }
                    }


                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 14.dp),
                    )


                    AssetProgressIndicator(
                        title = AssetScreenStrings.asset_info_percent,
                        goalValue = "${String.format("%.1f", asset.percentGoal)}%",
                        currentValue = String.format("%.1f", asset.percentOwned),
                        contributeStatus = asset.contributeState,
                        progress = getProgress(
                            currentValue = asset.percentOwned,
                            goalValue = asset.percentGoal
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    AssetProgressIndicator(
                        title = AssetScreenStrings.asset_info_units,
                        goalValue = String.format("%.0f", asset.unitsGoal),
                        currentValue = String.format("%.0f", asset.units),
                        contributeStatus = asset.contributeState,
                        progress = getProgress(
                            currentValue = asset.units,
                            goalValue = asset.unitsGoal
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    AssetProgressIndicator(
                        title = AssetScreenStrings.asset_info_money,
                        goalValue = String.format("R$ %.2f", asset.investedAmountGoal),
                        currentValue = String.format("%.2f", asset.investedAmount),
                        contributeStatus = asset.contributeState,
                        progress = getProgress(
                            currentValue = asset.investedAmount,
                            goalValue = asset.investedAmountGoal
                        )
                    )

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 48.dp, vertical = 20.dp),
                        color = RebalanceColors.greyColor.copy(alpha = 0.5f)
                    )

                    AssetPresenterInvestmentTip(
                        modifier = Modifier.padding(horizontal = 24.dp),
                        asset = asset,
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }

}

private fun getProgress(currentValue: Double, goalValue: Double): Float {
    return if (currentValue >= goalValue) {
        1.0f
    } else {
        (currentValue / goalValue).toFloat()
    }
}

private fun getColors100(status: ContributeStatus): Color {
    return when (status) {
        ContributeStatus.CONTRIBUTE -> RebalanceColors.green100
        ContributeStatus.WAIT -> RebalanceColors.red100
    }
}

private fun getColors200(status: ContributeStatus): Color {
    return when (status) {
        ContributeStatus.CONTRIBUTE -> RebalanceColors.green200
        ContributeStatus.WAIT -> RebalanceColors.red200
    }
}

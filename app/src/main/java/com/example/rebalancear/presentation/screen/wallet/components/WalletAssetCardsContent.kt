package com.example.rebalancear.presentation.screen.wallet.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.presentation.screen.tip.SimpleToolUpCenterArrowtip
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

@Composable
internal fun WalletAssetCardsContent(
    modifier: Modifier = Modifier,
    walletAssets: List<WalletAssetPresenter>,
    seeWalletAssetToolTipVisibility: Boolean,
    onClickCard: (code: String) -> Unit,
) {
    Column {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .shadow(10.dp, clip = false)
                .zIndex(1f),
            color = RebalanceColors.neutral0,
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "BALANCE",
                    color = RebalanceColors.primaryColor,
                    style = ReBalanceTypography.Tittle.copy(fontSize = 22.sp, letterSpacing = 5.sp),
                    textAlign = TextAlign.End
                )
            }
        }
        LazyColumn(modifier = modifier) {
            items(walletAssets) { asset ->


                Spacer(modifier = Modifier.height(8.dp))
                WalletAssetCard(
                    onClickCard = onClickCard,
                    asset = asset
                )
                WalletAssetTooltip(seeWalletAssetToolTipVisibility)
                Spacer(modifier = Modifier.height(8.dp))

            }

            item() {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }

}


@Composable
fun WalletAssetTooltip(visibility: Boolean) {
    SimpleToolUpCenterArrowtip(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .padding(top = 4.dp),
        visibility = visibility,
        title = "Veja as informações do seu novo item:",
        subtitle = "Para ver mais detalhes sobre o item, clique nele. Você poderá também alterar suas informações e fazer as mudanças necessárias."
    )
}
package com.example.rebalancear.presentation.screen.wallet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.rebalancear.presentation.adsense.IAdSense
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.presentation.screen.adMob.BannerAdView
import com.example.rebalancear.presentation.screen.adMob.BannerAdViewWithMaxHeight
import com.example.rebalancear.presentation.screen.tip.SimpleToolUpCenterArrowtip
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors
import com.google.android.gms.ads.AdSize

@Composable
internal fun WalletAssetCardsContent(
    modifier: Modifier = Modifier,
    adsense: IAdSense,
    walletAssets: List<WalletAssetPresenter>,
    seeWalletAssetToolTipVisibility: Boolean,
    onClickCard: (code: String) -> Unit,
) {

    Column {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .shadow(elevation = 10.dp),
            color = RebalanceColors.primaryColor,
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(top = 12.dp),
                    text = "BALANCE",
                    color = RebalanceColors.whiteColor,
                    style = ReBalanceTypography.Tittle.copy(
                        fontSize = 18.sp,
                        letterSpacing = (-1).sp
                    ),
                    textAlign = TextAlign.End
                )
            }
        }
        LazyColumn(modifier = modifier) {
            item {
                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .background(RebalanceColors.primaryColor),
                    contentAlignment = Alignment.Center
                )
                {
                    BannerAdViewWithMaxHeight(
                        adsense = adsense,
                        adSizeMaxHeight = 50f
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }


            items(walletAssets) { asset ->

                WalletAssetCard(
                    onClickCard = onClickCard,
                    asset = asset
                )
                WalletAssetTooltip(seeWalletAssetToolTipVisibility)
                Spacer(modifier = Modifier.height(12.dp))
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
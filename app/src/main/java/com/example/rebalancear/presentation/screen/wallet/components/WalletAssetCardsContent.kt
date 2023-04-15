package com.example.rebalancear.presentation.screen.wallet.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter

@Composable
internal fun WalletAssetCardsContent(
    modifier: Modifier = Modifier,
    walletAssets: List<WalletAssetPresenter>,
    onClickCard: (code: String) -> Unit,
    onClickAddCard: () -> Unit,
) {


    Box(
        modifier = modifier,
    ) {
        Column {
            Spacer(modifier = Modifier.height(12.dp))
            LazyColumn {
                items(walletAssets) { asset ->
                    WalletAssetCard(
                        onClickCard = onClickCard,
                        asset = asset
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                item() {
                    AddWalletAssetCard(onClick = onClickAddCard)
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}
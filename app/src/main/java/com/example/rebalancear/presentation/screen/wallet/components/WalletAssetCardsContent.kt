package com.example.rebalancear.presentation.screen.wallet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.ui.theme.RebalanceColors

@Composable
internal fun WalletAssetCardsContent(
    modifier: Modifier = Modifier,
    walletAssets: List<WalletAssetPresenter>,
    navController: NavController,
    onAddwalleAssetCard: (code: String, units: Double) -> Unit,
) {
    var enableAddCardDialog by remember { mutableStateOf(false) }

    Box(
        modifier = modifier,
    ) {
        Column {
            Spacer(modifier = Modifier.height(12.dp))
            LazyColumn {
                items(walletAssets) { asset ->
                    WalletAssetCard(
                        navController = navController,
                        asset = asset
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                item() {
                    AddWalletAssetCard(
                        onClick = {
                            enableAddCardDialog = true
                        })
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }

        AddWalletAssetDialog(
            modifier = Modifier
                .background(RebalanceColors.neutral0)
                .align(Alignment.Center),
            enable = enableAddCardDialog,
            onAdd = { code, units ->
                onAddwalleAssetCard(code, units)
                enableAddCardDialog = false
            },
            onCancel = { enableAddCardDialog = false }
        )

    }
}
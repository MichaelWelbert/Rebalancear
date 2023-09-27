package com.example.app.presentation.ui.components.assets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.presentation.presenter.AssetPresenter


@Composable
fun WalletAssetCardList (
    wallet: List<AssetPresenter>,
    onClickCard: (code: String) -> Unit,
) {
    LazyColumn() {
        items(wallet) { asset ->
            AssetCard(
                code = asset.code,
                percentGoal = asset.goal,
                percentOwned = asset.owned,
                onClickCard = { onClickCard(asset.code) },
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun PreviewList() {
    val wallet = listOf(
        AssetPresenter("BBAS3", 1f,20f, 20f, 0.5f, 0.2f),
        AssetPresenter("ITSA4", 1f,50f,50f, 0.2f, 0.5f),
        AssetPresenter("BBSE4", 1f,30f, 30f, 0.3f, 0.3f),

        )
    WalletAssetCardList (
        wallet
    ) {}
}
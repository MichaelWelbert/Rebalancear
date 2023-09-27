package com.example.app.presentation.ui.components.assets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.presentation.theme.Colors
import com.example.rebalancear.presentation.ui.theme.style

@Composable
internal fun AssetCard(
    code: String,
    percentGoal: Float,
    percentOwned: Float,
    onClickCard: () -> Unit,
) {
    Column(
        Modifier
            .clickable { onClickCard() }
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .background(Colors.whiteColor, shape = RoundedCornerShape(30.dp))
            .padding(16.dp)

    ) {

        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = code,
            color = Colors.blackColor,
            style = style.Body5
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(
                    Colors.blackColor.copy(alpha = 0.85f),
                    shape = RoundedCornerShape(35.dp)
                )
        ) {
            Progress(percentGoal = percentGoal, percentOwned = percentOwned)
        }

    }

}

@Composable
@Preview
internal fun AssetCardPreview() {
    AssetCard(
        code = "BBAS3",
        percentGoal = 0.25f,
        percentOwned = 0.10f,
        onClickCard = {}
    )
}
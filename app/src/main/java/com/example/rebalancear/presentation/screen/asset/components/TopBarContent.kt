package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

@Composable
internal fun TopbarContent(
    code: String,
    onClickDelete: () -> Unit,
    onClickBack: () -> Unit,
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f),
                    text = code,
                    color = RebalanceColors.neutral0,
                    style = ReBalanceTypography.Tittle,
                    textAlign = TextAlign.Start
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Bottom
                ) {
                    IconButton(onClick = onClickDelete) {
                        Icon(
                            Icons.Rounded.Delete, "", tint = RebalanceColors.red100
                        )
                    }
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = onClickBack) {
                Icon(
                    Icons.Filled.ArrowBack, "", tint = RebalanceColors.neutral0
                )
            }
        },

        backgroundColor = RebalanceColors.neutral500,
        elevation = 10.dp
    )
}

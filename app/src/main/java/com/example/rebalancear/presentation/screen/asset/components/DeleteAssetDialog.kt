package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

@Composable
internal fun DeleteAssetDialog(
    modifier: Modifier = Modifier,
    enable: Boolean,
    onConfirm: () -> Unit,
    onCancel: () -> Unit
) {
    if (enable) {
        Box(modifier = modifier
            .fillMaxSize()
            .background(color = RebalanceColors.blackColor.copy(alpha = 0.5f))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onCancel() }) {
            DialogWalletAsset(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .background(RebalanceColors.whiteColor, RoundedCornerShape(20.dp))
                    .align(Alignment.Center),
                onConfirm = onConfirm,
                onCancel = onCancel,
            )
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DialogWalletAsset(
    modifier: Modifier = Modifier,
    onConfirm: () -> Unit,
    onCancel: () -> Unit,
) {

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(RebalanceColors.whiteColor),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp),

        ) {
        Column(modifier = Modifier.padding(32.dp)) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Você tem certeza de que deseja deletar essa ação? Lembre-se de que essa ação será removida permanentemente da sua carteira assim que a operação for concluída.",
                color = RebalanceColors.blackColor,
                style = ReBalanceTypography.Body3,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onConfirm,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, false),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 2.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = RebalanceColors.secondaryColor
                    ),
                    shape = RoundedCornerShape(20),

                    ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "Deletar",
                        color = RebalanceColors.whiteColor,
                        style = ReBalanceTypography.Strong3.copy(
                            textAlign = TextAlign.Start
                        ),
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = onCancel,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, false),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 2.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = RebalanceColors.primaryColor
                    ),
                    shape = RoundedCornerShape(20),

                    ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "Cancelar",
                        color = RebalanceColors.whiteColor,
                        style = ReBalanceTypography.Strong3.copy(
                            textAlign = TextAlign.Start
                        ),
                    )
                }
            }
        }
    }
}
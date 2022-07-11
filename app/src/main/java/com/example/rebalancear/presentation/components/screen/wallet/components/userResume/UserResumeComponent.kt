package com.example.rebalancear.presentation.components.screen.wallet.components.userResume

import android.icu.text.NumberFormat
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.core.RebalanceStrings
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors


@Composable
fun UserResumeComponent(patrimony: Float) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp, horizontal = 16.dp),
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = RebalanceStrings.wallet_patrimony,
            color = RebalanceColors.white,
            style = ReBalanceTypography.Strong5,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = NumberFormat.getInstance().format(patrimony),
            color = RebalanceColors.white,
            style = ReBalanceTypography.Strong5,
            textAlign = TextAlign.Center
        )
    }

}
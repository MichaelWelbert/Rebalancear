package com.example.app.presentation.ui.components.floating

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.core.strings.Strings.WalletFloatButtonSubtitle
import com.example.app.core.strings.Strings.WalletFloatButtonTitle
import com.example.app.presentation.theme.Colors
import com.example.rebalancear.presentation.screen.tip.SimpleToolDownArrowtip

@Composable
fun FloatButton(
    toolTipVisible: Boolean,
    onClickFloatingButton: () -> Unit,
    backgroundColor: Color = Colors.pinkColor,
    icon: ImageVector = Icons.Filled.Add,
    iconColor: Color = Colors.whiteColor,
) {

    Column(
        horizontalAlignment = Alignment.End
    ) {

        SimpleToolDownArrowtip(
            visibility = toolTipVisible,
            modifier = Modifier
                .width(220.dp)
                .padding(end = 12.dp, bottom = 4.dp),
            title = WalletFloatButtonTitle,
            subtitle = WalletFloatButtonSubtitle
        )

        FloatingActionButton(
            onClick = onClickFloatingButton,
            backgroundColor = backgroundColor,
            contentColor = iconColor,
            shape = RoundedCornerShape(16.dp)
        ) {
            Icon(icon, "")
        }
    }
}

@Preview()
@Composable
private fun WalletFloatButtonPreview() {
    FloatButton(toolTipVisible = false, onClickFloatingButton = {})
}
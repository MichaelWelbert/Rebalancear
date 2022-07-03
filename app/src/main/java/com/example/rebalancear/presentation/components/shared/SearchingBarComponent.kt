package com.example.rebalancear.presentation.components.shared

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.R
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors

@Composable
fun SearchingBarComponent(
    placeholderText: String,
    textFieldValue: String,
    onTextFieldChanged: (String) -> Unit,
    onClickSearch: () -> Unit,
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(36.dp)),
        value = textFieldValue,
        onValueChange = {
            onTextFieldChanged(it.uppercase())
        },
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable {
                    onClickSearch()
                },
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                tint = RebalanceColors.darkGrey
            )
        },
        placeholder = {
            Text(
                text = placeholderText,
                color = RebalanceColors.lightGrey.copy(alpha = 0.3f),
                style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            placeholderColor = RebalanceColors.darkRed,
            cursorColor = RebalanceColors.lightGrey,
            containerColor = RebalanceColors.white,
            focusedIndicatorColor = RebalanceColors.lightGrey,
            textColor = RebalanceColors.lightGrey
        ),

        enabled = true,
        singleLine = true,
        readOnly = false,
        maxLines = 1,
        textStyle = ReBalanceTypography.Strong3
    )

}
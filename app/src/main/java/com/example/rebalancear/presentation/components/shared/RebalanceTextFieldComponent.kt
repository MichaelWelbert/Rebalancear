package com.example.rebalancear.presentation.components.shared

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors

@Composable
fun RebalanceTextFieldComponent(
    placeholderText: String,
    noTextInputMessage: String,
    filledTextInputMessage: String,
    readOnly: Boolean = false,
    textFieldValue: String,
    onTextFieldChanged: (String) -> Unit
) {


    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .clip(RoundedCornerShape(28.dp)),
            value = textFieldValue,
            onValueChange = {
                onTextFieldChanged(it.uppercase())
            },
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = placeholderText,
                    color = if (readOnly) RebalanceColors.white else RebalanceColors.lightGrey.copy(alpha = 0.3f),
                    style = ReBalanceTypography.Strong3.copy(textAlign = TextAlign.Center),
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = if (readOnly) Color.Transparent else RebalanceColors.lightGrey,
                containerColor = if (readOnly) Color.Transparent else RebalanceColors.white,
                focusedIndicatorColor = if (readOnly) Color.Transparent else RebalanceColors.lightGrey,
                textColor =  if (readOnly) RebalanceColors.white else RebalanceColors.lightGrey,
                disabledIndicatorColor = if (readOnly) Color.Transparent else RebalanceColors.lightGrey,
                focusedLabelColor = if (readOnly) Color.Transparent else RebalanceColors.lightGrey,
                unfocusedIndicatorColor = if (readOnly) Color.Transparent else RebalanceColors.lightGrey,
                unfocusedLabelColor = if (readOnly) Color.Transparent else RebalanceColors.lightGrey,
            ),

            enabled = true,
            singleLine = true,
            readOnly = readOnly,
            maxLines = 1,
            textStyle = ReBalanceTypography.Strong2.copy(textAlign = TextAlign.Center)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f),
            text = if (textFieldValue.isBlank()) noTextInputMessage else filledTextInputMessage,
            color = RebalanceColors.white,
            style = ReBalanceTypography.Strong2.copy(textAlign = TextAlign.Center),
        )
    }
}
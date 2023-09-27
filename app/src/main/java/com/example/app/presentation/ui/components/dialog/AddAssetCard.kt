package com.example.app.presentation.ui.components.dialog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.presentation.theme.Colors
import com.example.app.presentation.theme.ThemeTypography
import com.example.rebalancear.R

val validDecimalRegx = """\d{1,2}(.\d{0,2})?""".toRegex()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAssetCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    keyboardOptions: KeyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters),
    enableBackButton: Boolean = false,
    cardColor: Color = Colors.whiteColor,
    message: String,
    errorMessage: String? = null,
    textFieldPlaceHolder: String,
    buttonText: String,
    onConfirm: (data: String) -> Unit,
    onBack: () -> Unit
) {
    var textFieldValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Box {
            Card(
                modifier = modifier
                    .padding(4.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {

                    },
                shape = RoundedCornerShape(25.dp),
                colors = CardDefaults.cardColors(cardColor),

                ) {
                Column(
                    Modifier.fillMaxWidth(0.75f)
                ) {
                    InfoImage(image)
                    InfoMessage(message, errorMessage)
                    Spacer(modifier = Modifier.height(24.dp))
                    InfoTextField(
                        placeholderText = textFieldPlaceHolder,
                        text = textFieldValue,
                        keyboardOptions = keyboardOptions,
                        onTextChanged = {
                            textFieldValue = it.uppercase()
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(buttonText) {
                        onConfirm(textFieldValue)
                    }
                    Spacer(modifier = Modifier.height(28.dp))
                }
            }

            if (enableBackButton) {
                Button(
                    onClick = onBack,
                    modifier = Modifier
                        .size(60.dp)
                        .offset((-15).dp, (-15).dp),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 1.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Colors.pinkColor
                    ),
                    shape = RoundedCornerShape(40.dp),
                ) {
                    Text(
                        text = "<",
                        color = Colors.whiteColor,
                        style = ThemeTypography.peaceSans.body24,
                    )
                }
            }
        }
    }

}

@Composable
private fun InfoImage(@DrawableRes image: Int) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 42.dp),
        painter = painterResource(id = image),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}


@Composable
private fun InfoMessage(message: String, errorMessage: String?) {
    if (errorMessage.isNullOrBlank()) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            text = message,
            color = Colors.blackColor.copy(alpha = 0.8f),
            style = ThemeTypography.roboto.body14,
            textAlign = TextAlign.Center
        )
    } else {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            text = errorMessage,
            color = Colors.pinkColor,
            style = ThemeTypography.roboto.strong14,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun InfoTextField(
    placeholderText: String,
    text: String,
    keyboardOptions: KeyboardOptions,
    onTextChanged: (text: String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.padding(horizontal = 32.dp),
        value = text,
        onValueChange = onTextChanged,
        placeholder = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = placeholderText,
                color = Colors.blackColor.copy(alpha = 0.3f),
                style = ThemeTypography.roboto.strong14,
                textAlign = TextAlign.Center
            )
        },
        shape = RoundedCornerShape(24.dp),
        keyboardOptions = keyboardOptions,
        singleLine = true,
        textStyle = ThemeTypography.roboto.strong16.copy(textAlign = TextAlign.Center),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            errorCursorColor = Colors.pinkColor,
            errorBorderColor = Colors.pinkColor,
            containerColor = Colors.whiteColor,
            unfocusedBorderColor = Colors.greyColor,
            focusedBorderColor = Colors.blackColor,
            cursorColor = Colors.blackColor,
            textColor = Colors.blackColor
        )
    )
}

@Composable
private fun Button(
    text: String,
    onConfirm: () -> Unit
) {

    Button(
        onClick = { onConfirm() },
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 32.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 1.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Colors.pinkColor
        ),
        shape = RoundedCornerShape(40.dp),

        ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = text,
            color = Colors.whiteColor,
            style = ThemeTypography.roboto.strong14.copy(
                textAlign = TextAlign.Start
            ),
        )
    }
}

@Composable
@Preview
fun AddAssetCardPreview() {
    AddAssetCard(
        message = "QUAL O CODIGO DA AÇÃO QUE VOCE GOSTARIA DE ADICIONAR? O CÓDIGO É REPRESENTADO POR LETRAS E NUMEROS.",
        image = R.drawable.mascot_female_assets,
        buttonText = "CONTINUAR",
        textFieldPlaceHolder = "DIGITE O CÓDIGO",
        onConfirm = {},
        onBack = {}
    )
}
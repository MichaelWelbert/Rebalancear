package com.example.app.presentation.ui.components.assets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.presentation.theme.Colors
import com.example.app.presentation.theme.ThemeTypography
import com.example.rebalancear.R


@Composable
fun AssetAppAd() {
    Column(
        Modifier
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .background(
                Colors.whiteColor.copy(alpha = 0.1f),
                shape = RoundedCornerShape(24.dp)
            )
    ) {
        Divider(
            modifier = Modifier.padding(horizontal = 32.dp),
            color = Colors.whiteColor,
            thickness = 1.dp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(0.7f, false),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "Que tal ver qual seria o valor justo a se pagar nessa ação segundo os métodos do Barsi?",
                    color = Colors.whiteColor,
                    style = ThemeTypography.roboto.body14,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {},
                    modifier = Modifier.width(150.dp),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 1.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Colors.pinkColor
                    ),
                    shape = RoundedCornerShape(20),

                    ) {
                    Text(
                        text = "Descobrir",
                        color = Colors.whiteColor,
                        style =  ThemeTypography.peaceSans.body14.copy(
                            textAlign = TextAlign.Start
                        ),
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(0.3f, false),
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.mascot_male),
                    contentDescription = null,
                )
            }
        }

        Divider(
            modifier = Modifier.padding(horizontal = 32.dp),
            color = Colors.whiteColor,
            thickness = 1.dp
        )
    }
}

@Preview
@Composable
fun AppPreview() {
    AssetAppAd()
}
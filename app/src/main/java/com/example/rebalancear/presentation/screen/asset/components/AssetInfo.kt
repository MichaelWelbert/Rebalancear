package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.example.rebalancear.R
import com.example.rebalancear.presentation.ui.theme.Colors
import com.example.rebalancear.presentation.ui.theme.style
import kotlin.math.round

@Composable
internal fun AssetInfo(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(42.dp),
            text = "BBAS3",
            color = Colors.whiteColor,
            style = style.Body5,
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Price(modifier.weight(0.25f, true))
            Details(
                modifier.weight(0.75f, false),
                25.0,
                4.0
            )
        }

        Spacer(modifier = Modifier.height(36.dp))

        UserInfo()


        Spacer(modifier = Modifier.height(48.dp))

        AppAd()

        Spacer(modifier = Modifier.height(16.dp))
    }

}


@Composable
private fun AppAd(modifier: Modifier = Modifier) {
    Column(
        Modifier.background(
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
            modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier
                    .fillMaxWidth()
                    .weight(0.7f, false),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "O Barsi maior investidor pessoa física do Brasil criou um método para definir se uma ação está cara ou barata baseando na quantidade de dividendos.Que tal ver qual seria o valor justo a se pagar nessa ação segundo os métodos do Barsi?",
                    color = Colors.whiteColor,
                    style = style.BodyR1,
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
                        containerColor = Colors.secondaryColor
                    ),
                    shape = RoundedCornerShape(20),

                    ) {
                    Text(
                        text = "Descobrir",
                        color = Colors.whiteColor,
                        style = style.Body2.copy(
                            textAlign = TextAlign.Start
                        ),
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

            }

            Column(
                modifier
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

@Composable
private fun UserInfo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Possuo",
                color = Colors.greyColor,
                style = style.Body3,
                textAlign = TextAlign.Center
            )
            Text(
                text = "30 unidades",
                color = Colors.whiteColor,
                style = style.Body4,
                textAlign = TextAlign.Center
            )
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(

                text = "Investidos",
                color = Colors.greyColor,
                style = style.Body3,
                textAlign = TextAlign.Center
            )
            Text(
                text = "R$4850",
                color = Colors.whiteColor,
                style = style.Body4,
                textAlign = TextAlign.Center
            )
        }

    }
}

@Composable
private fun Price(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.mascot_female),
            contentDescription = null,
        )
      /*    Text(
              modifier = Modifier.fillMaxWidth(),
              text = "PREÇO ATUAL",
              color = RebalanceColors.greyColor,
              style = style.Body1,
              textAlign = TextAlign.Center
          )
          Text(
              modifier = Modifier.fillMaxWidth(),
              text = "R$48,52",
              color = RebalanceColors.whiteColor,
              style = style.Body4,
              textAlign = TextAlign.Center
          )

       */
    }
}

@Composable
private fun Details(
    modifier: Modifier = Modifier,
    percentGoal: Double,
    percentOwned: Double,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "META",
            color = Colors.whiteColor,
            style = style.Body4,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            Modifier
                .padding(horizontal = 18.dp)
                .fillMaxWidth()
                .height(25.dp)
                .background(
                    Colors.whiteColor,
                    shape = RoundedCornerShape(35.dp)
                )
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.CenterEnd

            ) {
                Text(
                    modifier = Modifier.padding(end = 15.dp),
                    text = round(percentGoal).toInt().toString() + "%",
                    color = Colors.secondaryColor,
                    style = style.Body2
                )

            }
            Box(
                Modifier
                    .fillMaxWidth(0.4f)
                    .fillMaxHeight()
                    .background(Colors.secondaryColor, shape = RoundedCornerShape(35.dp)),
                contentAlignment = Alignment.CenterEnd

            ) {
                Text(
                    modifier = Modifier.padding(end = 15.dp),
                    text = round(percentOwned).toInt().toString() + "%",
                    color = Colors.whiteColor,
                    style = style.Body2
                )

            }
        }
        Spacer(modifier = Modifier.height(12.dp))

      /*  Text(
            modifier = Modifier.padding(horizontal = 24.dp),
            text = "FALTA 1 UNIDADE PARA ATINGIR SUA META",
            color = RebalanceColors.whiteColor,
            style = style.BodyR2,
            textAlign = TextAlign.Center
        )

       */
        Spacer(modifier = Modifier.height(8.dp))
    }
}


@Preview(
    backgroundColor = 0xFF383838,
    showBackground = true
)
@Composable
internal fun AssetInfoPreview() {
    AssetInfo(modifier = Modifier)
}
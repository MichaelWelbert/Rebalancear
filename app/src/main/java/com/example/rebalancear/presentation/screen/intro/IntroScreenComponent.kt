package com.example.rebalancear.presentation.screen.intro


import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rebalancear.R
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors
import com.example.rebalancear.routes.Routes
import com.google.accompanist.pager.HorizontalPagerIndicator

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun IntroScreenComponent(
    navController: NavController,
) {

    val pages = listOf(
        PageInfo(
            title = "Balance",
            subTitle = "Seja bem-vindo ao Balance! Aqui, o controle dos seus investimentos está ao alcance das suas mãos. Defina suas metas financeiras e observe o seu progresso em uma experiência fácil e intuitiva. ",
            image = R.drawable.mascot3

        ), PageInfo(
            title = "Gerencia ativos",
            subTitle = "Diga adeus às oportunidades perdidas. Adicione diversos ativos e defina a proporção de cada um de acordo com seus objetivos financeiros. Nosso aplicativo mantém você informado sobre suas metas pendentes e o quanto você precisa investir para alcançá-las.",
            image = R.drawable.mascot1
        ), PageInfo(
            title = "Alcance metas",
            subTitle = "Prepare-se para uma experiência de investimento otimizada, sua jornada financeira começa agora!",
            image = R.drawable.mascot2
        )
    )
    val pagerState = rememberPagerState()


    Box(
        Modifier
            .fillMaxSize()
            .background(RebalanceColors.primaryColor),
    ) {
        HorizontalPager(
            pageCount = 3,
            state = pagerState,
        ) { position ->
            Page(
                pages[position],
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPagerIndicator(
                pagerState = pagerState,
                pageCount = 3,
                activeColor = RebalanceColors.secondaryColor,
                inactiveColor = RebalanceColors.whiteColor
            )

            if (pagerState.currentPage == pages.lastIndex) {
                Spacer(modifier = Modifier.height(24.dp))
                Box(Modifier.height(80.dp)) {
                    Button(
                        onClick = {
                            navController.popBackStack()
                            navController.navigate(Routes.WalletScreen.route)
                        },
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
                            text = "Começar",
                            color = RebalanceColors.whiteColor,
                            style = ReBalanceTypography.Strong3.copy(
                                textAlign = TextAlign.Start
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
            } else {
                Spacer(modifier = Modifier.height(110.dp))
            }
        }
    }


}

data class PageInfo(
    val title: String,
    val subTitle: String,
    @DrawableRes val image: Int,
)

@Composable
internal fun Page(
    pageInfo: PageInfo,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            painter = painterResource(id = pageInfo.image),
            contentDescription = null,
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,

            ) {



            Spacer(modifier = Modifier.height(36.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = pageInfo.title,
                color = RebalanceColors.whiteColor,
                style = ReBalanceTypography.Strong5.copy(letterSpacing = (-1).sp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = pageInfo.subTitle,
                color = RebalanceColors.whiteColor,
                style = ReBalanceTypography.Body3,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

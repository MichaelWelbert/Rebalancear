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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rebalancear.R
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors
import com.example.rebalancear.routes.Routes
import com.google.accompanist.pager.HorizontalPagerIndicator

/*
O Balance é o aplicativo ideal para quem quer investir na bolsa de valores sem complicação. Com ele, você define suas metas de ações e acompanha seu progresso de maneira super fácil.

Adicione uma ação à sua carteira e defina qual a porcentagem que deseja alcançar com ela. O Balance auxilia na gestão dos seus investimentos e te ajuda a atingir seus objetivos de forma eficiente.

Sempre que você tiver uma meta em aberto, o aplicativo te avisará e informará o valor necessário para alcançá-la. Dessa forma, você estará sempre atualizado e não perderá oportunidades de investimento.
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun IntroScreenComponent(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    //create https://www.google.com/search?q=intro+app+compose+slide+change+screen&sxsrf=APwXEdcYQt0f5zuypx-XsYTYjAo15GA_rg%3A1681655792135&ei=8Ac8ZMz4B_zf5OUP7eCz4AM&oq=intro+app+compose+slide&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAxgAMgUIIRCgATIFCCEQoAE6BAgjECc6CwgAEIAEELEDEIMBOg4ILhCDARDUAhCxAxCKBToFCAAQgAQ6CAgAEIAEELEDOg4ILhCABBCxAxDHARDRAzoRCC4QgAQQsQMQgwEQxwEQ0QM6BwgAEIoFEEM6CwguEIMBELEDEIAEOg4ILhCDARCxAxCABBDqBDoLCAAQigUQsQMQgwE6DQguEIoFEMcBENEDEEM6CAguEIAEELEDOhkILhCDARCxAxCABBDqBBDcBBDeBBDgBBgBOgoIABCKBRCxAxBDOgcILhANEIAEOgcIABANEIAEOgQIABADOgUILhCABDoICAAQgAQQywE6BggAEBYQHjoICAAQFhAeEA86BAghEBU6CAghEBYQHhAdOgoIIRAWEB4QDxAdSgQIQRgAUABY-BpgqSpoAHAAeACAAZ4CiAHyIJIBBjAuMTcuNpgBAKABAcABAdoBBggBEAEYFA&sclient=gws-wiz-serp#fpstate=ive&vld=cid:533c64b5,vid:6dRwaXH2cYA

    val pages = listOf(
        PageInfo(
            title = "Balance",
            subTitle = "O Balance é o aplicativo ideal para quem quer investir na bolsa de valores sem complicação. Com ele, você define suas metas de ações e acompanha seu progresso de maneira super fácil. ",
            image = R.drawable.onbord1

        ), PageInfo(
            title = "Gerencia ativos",
            subTitle = "Adicione um ativo à sua carteira e defina qual a porcentagem que deseja alcançar com ele. O Balance auxilia na gestão dos seus investimentos e te ajuda a atingir seus objetivos de forma eficiente.",
            image = R.drawable.onbord2
        ), PageInfo(
            title = "Alcance metas",
            subTitle = "Sempre que você tiver uma meta em aberto, o aplicativo te avisará e informará o valor necessário para alcançá-la. Dessa forma, você estará sempre atualizado e não perderá oportunidades de investimento.",
            image = R.drawable.onbord3
        )
    )
    val pagerState = rememberPagerState()


    Box(
        Modifier
            .fillMaxSize()
            .background(RebalanceColors.whiteColor),
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
                activeColor = RebalanceColors.primaryColor,
                inactiveColor = RebalanceColors.greyColor
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
                            containerColor = RebalanceColors.primaryColor
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,

        ) {

        Image(
            modifier = Modifier
                .scale(1.2f)
                .fillMaxWidth(),
            painter = painterResource(id = pageInfo.image),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth().padding(horizontal = 16.dp),
            text = pageInfo.title,
            color = RebalanceColors.blackColor.copy(alpha = 0.7f),
            style = ReBalanceTypography.Strong5,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth().padding(horizontal = 16.dp),
            text = pageInfo.subTitle,
            color = RebalanceColors.blackColor.copy(alpha = 0.7f),
            style = ReBalanceTypography.Body3,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))
    }

}

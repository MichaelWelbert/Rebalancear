package com.example.rebalancear.presentation.components.screen.asset

import android.icu.text.NumberFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rebalancear.R
import com.example.rebalancear.core.AssetTypes
import com.example.rebalancear.core.ContributeState
import com.example.rebalancear.core.RebalanceStrings
import com.example.rebalancear.core.RecordType
import com.example.rebalancear.presentation.components.screen.asset.components.RecordAssetComponent
import com.example.rebalancear.presentation.components.shared.ActionCardComponent
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.routes.Routes
import com.example.rebalancear.ui.theme.ReBalanceTypography
import com.example.rebalancear.ui.theme.RebalanceColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssetScreenComponent(
    navController: NavController
) {
    var goalFieldState by remember {
        mutableStateOf("8")
    }
    var assetUnitFieldState by remember {
        mutableStateOf("")
    }

    var assetPriceFieldState by remember {
        mutableStateOf("")
    }

    var editGoalState by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f),
                            text = "BBAS3",
                            color = RebalanceColors.white,
                            style = ReBalanceTypography.Tittle,
                            textAlign = TextAlign.Start
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            IconButton(onClick = {}) {
                                Icon(
                                    Icons.Rounded.Delete,
                                    "backIcon",
                                    tint = RebalanceColors.red200
                                )
                            }
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            "backIcon",
                            tint = RebalanceColors.neutral0
                        )
                    }
                },

                backgroundColor =RebalanceColors.neutral500,
                elevation = 10.dp
            )
        },

        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(RebalanceColors.darkGrey)
                    .padding(horizontal = 16.dp),
            ) {

                LazyColumn() {
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    item() {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .border(
                                    1.dp, RebalanceColors.neutral300,
                                    RoundedCornerShape(20.dp)
                                )
                        ) {
                            Spacer(modifier = Modifier.height(16.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Row(
                                    modifier = Modifier,
                                    verticalAlignment = Alignment.Bottom
                                ) {
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Icon(
                                        modifier = Modifier
                                            .size(50.dp),
                                        painter = painterResource(id = R.drawable.ic_goal),
                                        contentDescription = null,
                                        tint = RebalanceColors.neutral0
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))

                                    Column() {
                                        Text(
                                            modifier = Modifier,
                                            text = "MINHA META É DE 8%",
                                            color = RebalanceColors.white,
                                            style = ReBalanceTypography.Strong4,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis,
                                        )
                                        Spacer(modifier = Modifier.height(2.dp))

                                        Text(
                                            modifier = Modifier,
                                            text = "TENHO ATUALMENTE 5%",
                                            color = RebalanceColors.white,
                                            style = ReBalanceTypography.Strong2,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis,
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                    }

                                }

                                Column(
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .padding(end = 28.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clip(CircleShape)
                                            .background(RebalanceColors.purple200)
                                    ) {
                                        Icon(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(6.dp),
                                            painter = painterResource(id = R.drawable.ic_edit),
                                            contentDescription = null,
                                            tint = RebalanceColors.purple0
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }



                    item {
                        ActionCardComponent(
                            title = "COMPRAR",
                            subtitle = "Investa agora R\$258,00 e atinja a sua meta!!",
                            backgroundColors = listOf(
                                RebalanceColors.green200,
                                RebalanceColors.green200,
                            ),
                            tittleBackgroundColor = RebalanceColors.green300,
                            onClick = {
                                navController.navigate(Routes.BuyAssetScreen.route)
                            }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    item {
                        ActionCardComponent(
                            title = "VENDER",
                            subtitle = "Quer vender algumas unidades do seu ativo? Faça isso por aqui!",
                            backgroundColors = listOf(
                                RebalanceColors.red200,
                                RebalanceColors.red200,
                            ),
                            tittleBackgroundColor = RebalanceColors.red300,
                            onClick = {}
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(32.dp))
                    }

                    item {
                        Text(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            text = "Histórico",
                            color = RebalanceColors.white,
                            style = ReBalanceTypography.Strong4,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )

                        Divider(
                            modifier = Modifier.padding(
                                start = 16.dp,
                                end = 16.dp,
                                top = 4.dp,
                                bottom = 8.dp
                            ),
                            color = RebalanceColors.neutral300
                        )
                    }

                    items(5) {
                        Spacer(modifier = Modifier.height(12.dp))
                        RecordAssetComponent(
                            WalletAssetPresenter(
                                code = "BBAS3",
                                assetType = AssetTypes.STOCKS,
                                investedAmount = 25000f,
                                percentageGoal = 5f,
                                percentageOwned = 2f,
                                contributeState = ContributeState.CONTRIBUTE
                            ),
                            recordType = RecordType.BUY
                        )
                    }

                    items(5) {
                        Spacer(modifier = Modifier.height(12.dp))
                        RecordAssetComponent(
                            WalletAssetPresenter(
                                code = "HGRU11",
                                assetType = AssetTypes.STOCKS,
                                investedAmount = 5000f,
                                percentageGoal = 3f,
                                percentageOwned = 4f,
                                contributeState = ContributeState.WAIT
                            ),
                            recordType = RecordType.SELL
                        )
                    }
                }

                /*  LazyColumn {
                      item {
                          ActionCardComponent(
                              title = "COMPRAR",
                              subtitle = "Quer comprar algumas unidades do seu ativo? Faça isso por aqui!",
                              icon = R.drawable.ic_add_circle,
                              colors = listOf(
                                  RebalanceColors.darkOceanBlue,
                                  RebalanceColors.lightOceanBlue
                              ),
                              onClick = {
                                  navController.navigate(Routes.BuyAssetScreen.route)
                              }
                          )

                          Spacer(modifier = Modifier.height(20.dp))

                          ActionCardComponent(
                              title = "VENDER",
                              subtitle = "Quer vender algumas unidades do seu ativo? Faça isso por aqui!",
                              icon = R.drawable.ic_remove_circle,
                              colors = listOf(
                                  RebalanceColors.darkRed,
                                  RebalanceColors.lightRed
                              ),
                              onClick = {}
                          )

                          Spacer(modifier = Modifier.height(20.dp))

                          ActionCardComponent(
                              title = "HISTÓRICO",
                              subtitle = "Deseja ver o historico de compra desse ativo? Faça isso por aqui!",
                              icon = R.drawable.ic_record,
                              colors = listOf(
                                  RebalanceColors.darkYellow,
                                  RebalanceColors.lightYellow
                              ),
                              onClick = {}
                          )

                          Spacer(modifier = Modifier.height(20.dp))

                          ActionCardComponent(
                              title = "EDITAR",
                              subtitle = "Deseja editar seu objetivo esse ativo? Faça isso por aqui!",
                              icon = R.drawable.ic_edit,
                              colors = listOf(
                                  RebalanceColors.green300,
                                  RebalanceColors.green100
                              ),
                              onClick = {}
                          )

                          Spacer(modifier = Modifier.height(20.dp))

                          ActionCardComponent(
                              title = "EXCLUIR",
                              subtitle = "Deseja excluir seu objetivo esse ativo? Faça isso por aqui!",
                              icon = R.drawable.ic_delete,
                              colors = listOf(
                                  RebalanceColors.darkGrey,
                                  RebalanceColors.lightGrey
                              ),
                              onClick = {}
                          )

                          Spacer(modifier = Modifier.height(20.dp))
                      }




                          LazyColumn {
                      items(12) {
                          Spacer(modifier = Modifier.height(12.dp))
                          RecordAssetComponent(
                              WalletAssetPresenter(
                                  code = "BBAS3",
                                  assetType = AssetTypes.STOCKS,
                                  investedAmount = 25000f,
                                  percentageGoal = 5f,
                                  percentageOwned = 2f,
                                  contributeState = ContributeState.CONTRIBUTE
                              ),
                              recordType = RecordType.BUY
                          )

                      }
                  }


                  }

                 */
            }
        })
}

/*

 */
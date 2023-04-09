package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rebalancear.core.strings.AssetScreenStrings
import com.example.rebalancear.presentation.presenters.AssetPresenter
import com.example.rebalancear.presentation.screen.SimpleAlertDialog
import com.example.rebalancear.presentation.viewmodels.AssetViewModel
import com.example.rebalancear.routes.Routes
import com.example.rebalancear.presentation.ui.theme.RebalanceColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AssetScreenContent(
    navController: NavController,
    asset: AssetPresenter,
    assetViewModel: AssetViewModel,
) {

    var enableDeleteCardDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopbarContent(code = asset.code,
                onClickDelete = { enableDeleteCardDialog = true },
                onClickBack = { navController.navigate(Routes.WalletScreen.route) }
            )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(RebalanceColors.neutral500)
                    .padding(horizontal = 16.dp),
            ) {
                if (enableDeleteCardDialog) {
                    SimpleAlertDialog(
                        content = AssetScreenStrings.asset_delete_dialog_text,
                        onDismiss = { enableDeleteCardDialog = false },
                        onConfirm = {
                            enableDeleteCardDialog = false
                            //TODO: DELETE ASSET
                            navController.navigate(Routes.WalletScreen.route)
                        },
                    )
                } else {
                    AssetPresenterCard(asset = asset)
                }
            }
        }
    )
}
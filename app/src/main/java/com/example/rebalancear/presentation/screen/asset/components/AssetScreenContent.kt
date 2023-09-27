package com.example.rebalancear.presentation.screen.asset.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rebalancear.presentation.events.AssetScreenEvents
import com.example.rebalancear.presentation.presenters.AssetPresenter
import com.example.rebalancear.presentation.ui.theme.Colors
import com.example.rebalancear.presentation.viewmodels.AssetViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AssetScreenContent(
    navController: NavController,
    asset: AssetPresenter,
    assetViewModel: AssetViewModel,
) {

    var dialogStatus by remember { mutableStateOf(DialogStatus.HIDE) }

    Scaffold(
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Colors.primaryColor)
            ) {
              /*  AssetPresenterCard(
                    modifier = Modifier.padding(innerPadding),
                    asset = asset,
                    onClickBack = {
                        navController.popBackStack()
                    },
                )

               */

                AssetInfo(modifier = Modifier.padding(innerPadding))

                EditAssetDialog(
                    enable = dialogStatus == DialogStatus.EDIT,
                    currentGoal = asset.percentGoal,
                    currentUnits = asset.units,
                    onEdit = { units, goal ->
                        assetViewModel.onTriggerEvent(
                            AssetScreenEvents.OnUpdateWalletAsset(asset.code, units, goal)
                        )

                        dialogStatus = DialogStatus.HIDE
                    },
                    onCancel = {
                        dialogStatus = DialogStatus.HIDE
                    }
                )

                DeleteAssetDialog(
                    enable = dialogStatus == DialogStatus.DELETE,
                    onConfirm = {
                        assetViewModel.onTriggerEvent(
                            event = AssetScreenEvents.OnDeleteAsset(asset.code)
                        )
                    },
                    onCancel = { dialogStatus = DialogStatus.HIDE }
                )
            }
        },
        floatingActionButton = {
            Column(
                horizontalAlignment = Alignment.End
            ) {
                FloatingActionButton(
                    onClick = {
                        if (dialogStatus == DialogStatus.HIDE)
                            dialogStatus = DialogStatus.EDIT
                    },
                    containerColor = Colors.secondaryColor,
                    contentColor = Colors.whiteColor,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Icon(Icons.Filled.Edit, "")
                }

                Spacer(modifier = Modifier.height(16.dp))

                FloatingActionButton(
                    onClick = {
                        if (dialogStatus == DialogStatus.HIDE)
                            dialogStatus = DialogStatus.DELETE
                    },
                    containerColor = Colors.primaryColor,
                    contentColor = Colors.whiteColor,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Icon(Icons.Filled.Delete, "")
                }
            }

        }
    )
}


private enum class DialogStatus {
    HIDE,
    DELETE,
    EDIT
}
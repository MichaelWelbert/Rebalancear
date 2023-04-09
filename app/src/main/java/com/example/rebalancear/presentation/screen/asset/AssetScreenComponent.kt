package com.example.rebalancear.presentation.screen.asset

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.rebalancear.presentation.screen.asset.components.AssetScreenContent
import com.example.rebalancear.presentation.states.PageState
import com.example.rebalancear.presentation.viewmodels.AssetViewModel


@Composable
internal fun AssetScreenComponent(
    navController: NavController,
    assetViewModel: AssetViewModel,
) {

    val assetState = assetViewModel.assetState


    when (assetState.state) {
        is PageState.Error -> {
        }
        is PageState.Loading -> {

        }
        is PageState.Success -> {
            AssetScreenContent(
                navController = navController,
                asset = assetState.state.data,
                assetViewModel = assetViewModel
            )
        }
        is PageState.Undefined -> {

        }
    }


}
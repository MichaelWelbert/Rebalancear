package com.example.rebalancear.presentation.screen.asset

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.rebalancear.presentation.events.AssetNavigationEvent
import com.example.rebalancear.presentation.screen.asset.components.AssetScreenContent
import com.example.rebalancear.presentation.states.base.RequestState
import com.example.rebalancear.presentation.viewmodels.AssetViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@Composable
internal fun AssetScreenComponent(
    navController: NavController,
    assetViewModel: AssetViewModel,
) {

    val assetState = assetViewModel.assetState
    val navigationEvent = assetViewModel.navigationEvent


    when (assetState.state) {
        is RequestState.Error -> {
        }
        is RequestState.Loading -> {

        }
        is RequestState.Success -> {
            AssetScreenContent(
                navController = navController,
                asset = assetState.state.data,
                assetViewModel = assetViewModel
            )
        }
        is RequestState.Undefined -> {

        }
    }

    LaunchedEffect(key1 = Unit) {
        navigationEvent.onEach { navigationEvent ->
            when(navigationEvent) {
                AssetNavigationEvent.OnAssetNavigationBack -> {
                    navController.previousBackStackEntry?.savedStateHandle ?.set("refreshOnDelete", true)
                    navController.navigateUp()
                }
            }

        }.launchIn(this)
    }
}
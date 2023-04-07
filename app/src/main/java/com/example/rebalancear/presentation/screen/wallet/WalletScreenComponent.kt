package com.example.rebalancear.presentation.screen.wallet

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pendulum.ui.theme.RebalanceColors
import com.example.rebalancear.presentation.states.PageState
import com.example.rebalancear.presentation.viewmodels.WalletViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun WalletScreenComponent(
    navController: NavController,
    walletViewModel: WalletViewModel,
) {
    val walletState = walletViewModel.walletState.state

    Scaffold(
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(RebalanceColors.neutral500)
                    .padding(8.dp),
            ) {
                when(walletState) {
                    is PageState.Error -> {

                    }
                    is PageState.Loading -> {

                    }
                    is PageState.Success -> {
                        Box( modifier = Modifier.background(Color.Green)) {
                            Text(text = walletState.data.toString())
                        }
                    }
                    is PageState.Undefined -> {}
                }
            }
        }
    )


}
package com.example.rebalancear.presentation.states

import com.example.rebalanceamentodecarteira.core.ResultError
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter

data class WalletState(
    val isLoading: Boolean = false,
    val assets: List<WalletAssetPresenter> = emptyList(),
    val error: ResultError? = null,
)
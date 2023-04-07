package com.example.rebalancear.presentation.states


import com.example.rebalancear.core.ResultError
import com.example.rebalancear.core.StateStatus

data class WalletState(
    val status: StateStatus = StateStatus.WAIT,
    val walletAssets: List<String> = emptyList(),
    val patrimony: Double = 0.0,
    val error: ResultError? = null,
)

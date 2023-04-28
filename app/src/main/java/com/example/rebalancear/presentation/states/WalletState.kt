package com.example.rebalancear.presentation.states


import com.example.rebalancear.presentation.presenters.WalletPresenter
import com.example.rebalancear.presentation.states.base.RequestState


internal data class WalletState(
    val state: RequestState<WalletPresenter> = RequestState.Undefined()
)

package com.example.rebalancear.presentation.states


import com.example.rebalancear.presentation.presenters.WalletPresenter


internal data class WalletState(
    val state: PageState<WalletPresenter> = PageState.Undefined()
)

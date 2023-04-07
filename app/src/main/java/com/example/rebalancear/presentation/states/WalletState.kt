package com.example.rebalancear.presentation.states


import com.example.rebalancear.presentation.presenters.WalletAssetPresenter


internal data class WalletState(
    val state: PageState<List<WalletAssetPresenter>> = PageState.Undefined()
)

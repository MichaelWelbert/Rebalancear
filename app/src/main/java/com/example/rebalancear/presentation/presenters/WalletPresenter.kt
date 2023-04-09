package com.example.rebalancear.presentation.presenters

data class WalletPresenter (
    val assets : List<WalletAssetPresenter> = emptyList(),
    val patrimony : Double = 0.0
)
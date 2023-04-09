package com.example.rebalancear.presentation.states

import com.example.rebalancear.presentation.presenters.AssetPresenter

internal data class AssetState(
    val state: PageState<AssetPresenter> = PageState.Undefined()
)
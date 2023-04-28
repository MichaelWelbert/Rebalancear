package com.example.rebalancear.presentation.states

import com.example.rebalancear.presentation.presenters.AssetPresenter
import com.example.rebalancear.presentation.states.base.RequestState

internal data class AssetState(
    val state: RequestState<AssetPresenter> = RequestState.Undefined()
)
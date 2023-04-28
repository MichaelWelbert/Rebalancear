package com.example.rebalancear.presentation.states

import com.example.rebalancear.presentation.states.base.RequestState
import com.example.rebalancear.presentation.states.base.VisibleState

internal data class AddAssetState(
    val visibility: VisibleState = VisibleState.Hide,
    val state: RequestState<Unit> = RequestState.Undefined()
)
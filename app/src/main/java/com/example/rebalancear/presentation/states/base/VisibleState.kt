package com.example.rebalancear.presentation.states.base

internal sealed class VisibleState {
    object Hide : VisibleState ()
    object Show : VisibleState ()
}
package com.example.rebalancear.presentation.presenters

import com.example.rebalancear.domain.status.ContributeStatus

data class AssetPresenter(
    val code: String = "",
    val units: Double = 0.0,
    val unitsGoal: Double = 0.0,
    val unitPrice: Double = 0.0,
    val percentGoal: Double = 0.0,
    val percentOwned: Double = 0.0,
    val investedAmount: Double = 0.0,
    val investedAmountGoal: Double = 0.0,
    val grahamFairPrice: Double = 0.0,
    val contributeState: ContributeStatus = ContributeStatus.WAIT,
)
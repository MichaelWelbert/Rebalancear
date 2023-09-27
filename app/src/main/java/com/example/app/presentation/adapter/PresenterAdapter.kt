package com.example.app.presentation.adapter

import com.example.app.domain.entities.Asset
import com.example.app.presentation.presenter.AssetPresenter
import javax.inject.Inject


class PresenterAdapter @Inject constructor() {

    fun buildAsset(asset: Asset, ownedPercent : Float, unitsGoal: Float): AssetPresenter {
        return AssetPresenter(
            code = asset.code,
            unitPrice = asset.unitPrice,
            units = asset.units,
            unitsGoal = unitsGoal,
            goal = asset.goal,
            owned = ownedPercent
        )
    }
}
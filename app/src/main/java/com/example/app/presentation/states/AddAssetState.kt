package com.example.app.presentation.states

import com.example.app.presentation.presenter.AddAssetPresenter


sealed class AddAssetState{
    object Hide : AddAssetState()

    class InsertAsset(val data: AddAssetPresenter) : AddAssetState()

    class InsertUnits(val data: AddAssetPresenter): AddAssetState()

    class InsertGoal(val data: AddAssetPresenter) : AddAssetState()

}


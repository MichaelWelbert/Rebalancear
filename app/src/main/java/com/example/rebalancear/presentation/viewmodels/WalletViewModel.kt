package com.example.rebalancear.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.domain.entities.WalletAsset
import com.example.rebalancear.domain.status.ContributeStatus
import com.example.rebalancear.domain.usecases.AddWalletAssetUseCase
import com.example.rebalancear.domain.usecases.CalculateGoalUseCase
import com.example.rebalancear.domain.usecases.CalculatePatrimonyUseCase
import com.example.rebalancear.domain.usecases.GetContributeStateUseCase
import com.example.rebalancear.domain.usecases.GetInvestedAmountUseCase
import com.example.rebalancear.domain.usecases.GetPercentageOwnedUseCase
import com.example.rebalancear.domain.usecases.GetWalletAssetsUseCase
import com.example.rebalancear.presentation.events.WalletAssetNavigationEvent
import com.example.rebalancear.presentation.events.WalletAssetPageEvent
import com.example.rebalancear.presentation.events.WalletAssetScreenEvents
import com.example.rebalancear.presentation.presenters.WalletAssetPresenter
import com.example.rebalancear.presentation.presenters.WalletPresenter
import com.example.rebalancear.presentation.states.AddAssetState
import com.example.rebalancear.presentation.states.WalletState
import com.example.rebalancear.presentation.states.base.RequestState
import com.example.rebalancear.presentation.states.base.VisibleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class WalletViewModel @Inject constructor(
    private val getWalletAssetsUseCase: GetWalletAssetsUseCase,
    private val getContributeStateUseCase: GetContributeStateUseCase,
    private val getInvestedAmountUseCase: GetInvestedAmountUseCase,
    private val getPercentageOwnedUseCase: GetPercentageOwnedUseCase,
    private val calculatePatrimonyUseCase: CalculatePatrimonyUseCase,
    private val calculateGoalUseCase: CalculateGoalUseCase,
    private val addWalletAssetUseCase: AddWalletAssetUseCase,
) : ViewModel() {


    private var _walletState by mutableStateOf(WalletState())
    val walletState get() = _walletState

    private var _addAssetState by mutableStateOf(AddAssetState())
    val addAssetState get() = _addAssetState

    private val _navigationEvent = MutableSharedFlow<WalletAssetNavigationEvent>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    private val _walletAssetPageEvent = MutableSharedFlow<WalletAssetPageEvent>()
    val alletAssetPageEvent = _walletAssetPageEvent.asSharedFlow()


    init {
        loadPage()
    }

    fun onTriggerEvent(event: WalletAssetScreenEvents) {
        when (event) {
            is WalletAssetScreenEvents.OnAddWalletAsset -> {
                addWalletAsset(event.code, event.units, event.goal)
            }
            WalletAssetScreenEvents.RefreshPage -> refreshPage()
            WalletAssetScreenEvents.ResetPage -> resetPage()
            is WalletAssetScreenEvents.OnClickAsset -> onClickAsset(event.code)
            WalletAssetScreenEvents.OnClickToDismissAddAssetButton -> onClickToDismissAddAssetButton()
            WalletAssetScreenEvents.OnClickAddAssetButton -> onClickAddAssetButton()
        }
    }

    private fun onClickAddAssetButton() {
        _addAssetState = AddAssetState(visibility = VisibleState.Show)
    }

    private fun onClickToDismissAddAssetButton() {
        _addAssetState = AddAssetState(visibility = VisibleState.Hide)
    }

    private fun resetPage() {
        _walletState = WalletState()
    }

    private fun refreshPage() {
        resetPage()
        loadPage()

    }

    private fun loadPage() {
        loadWalletAssets()
    }

    private fun onClickAsset(code: String) {
        viewModelScope.launch {
            _navigationEvent.emit(WalletAssetNavigationEvent.OnNavigationAsset(code))
        }
    }

    private fun loadWalletAssets() {
        getWalletAssetsUseCase().onEach { result ->
            _walletState = when (result) {
                is ResultRequest.Error -> {
                    WalletState(state = RequestState.Error(result.errorMessage))
                }
                is ResultRequest.Loading -> {
                    WalletState(state = RequestState.Loading())
                }
                is ResultRequest.Success -> {
                    val patrimony = calculatePatrimonyUseCase(result.data)
                    val goal = calculateGoalUseCase(result.data)
                    val assets = getWalletAssetPresenter(result.data, patrimony)
                    val walletPresenter = WalletPresenter(
                        assets = assets,
                        patrimony = patrimony,
                        goal = goal
                    )

                    WalletState(state = RequestState.Success(walletPresenter))
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun addWalletAsset(code: String, units: Double, goal: Double) {
        addWalletAssetUseCase(code, units, goal).onEach { result ->
            _addAssetState = when (result) {
                is ResultRequest.Error -> {
                    AddAssetState(
                        visibility = VisibleState.Show,
                        state = RequestState.Error(result.errorMessage)
                    )
                }
                is ResultRequest.Loading -> {
                    AddAssetState(
                        visibility = VisibleState.Show,
                        state = RequestState.Loading()
                    )
                }
                is ResultRequest.Success -> {
                    AddAssetState(
                        visibility = VisibleState.Hide,
                        state = RequestState.Success(Unit)
                    )
                }
            }
        }.launchIn(viewModelScope)
    }


    private fun getWalletAssetPresenter(
        walletAsset: List<WalletAsset>,
        patrimony: Double
    ): List<WalletAssetPresenter> {
        val walletAssets = walletAsset.map { asset ->
            val investedAmount = getInvestedAmountUseCase(
                units = asset.units,
                unitsPrice = asset.unitPrice
            )
            val percentOwned = getPercentageOwnedUseCase(
                patrimony = patrimony,
                investedAmount = investedAmount
            )
            val contributeState = getContributeStateUseCase(
                percentOwned = percentOwned,
                percentGoal = asset.percentGoal
            )

            WalletAssetPresenter(
                code = asset.code,
                percentGoal = asset.percentGoal,
                percentOwned = percentOwned.toDouble(),
                contributeState = contributeState,
            )
        }

        return orderAssetPresenter(walletAssets)
    }

    private fun orderAssetPresenter(walletAssets: List<WalletAssetPresenter>): List<WalletAssetPresenter> {
        return walletAssets.sortedByDescending { it.percentGoal }
            .sortedByDescending { it.contributeState == ContributeStatus.CONTRIBUTE }
    }
}
package com.example.rebalancear.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rebalancear.core.ResultError
import com.example.rebalancear.core.ResultRequest
import com.example.rebalancear.core.StateStatus
import com.example.rebalancear.domain.usecases.GetWalletAssetsUseCase
import com.example.rebalancear.presentation.states.WalletState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WalletViewModel @Inject constructor(
    private val getWalletAssetsUseCase: GetWalletAssetsUseCase,
) : ViewModel() {

    private var _walletState by mutableStateOf(WalletState())
    val walletState get() = _walletState


    init {
        loadWalletAssets()
    }

    private fun loadWalletAssets() {
        getWalletAssetsUseCase().onEach { result ->
            when (result) {
                is ResultRequest.Error -> {
                    _walletState = WalletState(
                        status = StateStatus.ERROR,
                        error = result.error
                    )
                }
                is ResultRequest.Loading -> {
                    _walletState = WalletState(
                        status = StateStatus.LOADING,
                    )
                }
                is ResultRequest.Success -> {
                    if (result.data == null) {
                        _walletState = WalletState(
                            status = StateStatus.ERROR,
                            error = ResultError.CannotFindData()
                        )

                        return@onEach
                    }


                    _walletState = WalletState(
                        status = StateStatus.READY,
                        walletAssets = listOf("deu bom"),
                        patrimony = 2000.0,
                    )

                }
            }
        }.launchIn(viewModelScope)
    }
}
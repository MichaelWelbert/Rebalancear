package com.example.rebalancear.presentation.states.base

import com.example.app.core.request.ErrorMessage

internal sealed class RequestState<T> {
    class Undefined<T> : RequestState<T>()
    class Loading<T> : RequestState<T>()
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error<T>(val errorMessage: ErrorMessage) : RequestState<T>()
}
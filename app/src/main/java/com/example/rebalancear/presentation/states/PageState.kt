package com.example.rebalancear.presentation.states

import com.example.rebalancear.core.ResultError

internal sealed class PageState<T> {
    class Undefined<T> : PageState<T>()
    class Loading<T> : PageState<T>()
    data class Success<T>(val data: T) :PageState<T>()
    data class Error<T>(val resultError: ResultError) :PageState<T>()
}
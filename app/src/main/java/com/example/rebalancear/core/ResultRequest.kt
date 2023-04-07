package com.example.rebalancear.core

sealed class ResultRequest<T>(val data: T? = null, val error: ResultError? = null) {
    class Success<T>(data: T) : ResultRequest<T>(data)
    class Loading<T>(data: T? = null) : ResultRequest<T>(data)
    class Error<T>(resultError: ResultError) : ResultRequest<T>(error = resultError)
}

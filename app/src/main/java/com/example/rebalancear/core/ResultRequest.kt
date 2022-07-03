package com.example.rebalanceamentodecarteira.core


sealed class ResultRequest<T>(val data: T? = null, val error: ResultError? = null) {
    class Success<T>(data: T) : ResultRequest<T>(data)
    class Loading<T>(data: T? = null) : ResultRequest<T>(data)
    class Error<T>(error: ResultError, data: T? = null) : ResultRequest<T>(data, error)
}

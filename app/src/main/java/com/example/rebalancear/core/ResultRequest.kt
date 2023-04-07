package com.example.rebalancear.core

sealed class ResultRequest<T>{
    class Success<T>(val data: T) : ResultRequest<T>()
    class Loading<T> : ResultRequest<T>()
    class Error<T>(val resultError: ResultError) : ResultRequest<T>()
}

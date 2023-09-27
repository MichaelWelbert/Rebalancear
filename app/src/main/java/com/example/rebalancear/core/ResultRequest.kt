package com.example.rebalancear.core

import com.example.app.core.request.ErrorMessage

sealed class ResultRequest<T>{
    class Success<T>(val data: T) : ResultRequest<T>()
    class Loading<T> : ResultRequest<T>()
    class Error<T>(val errorMessage: ErrorMessage) : ResultRequest<T>()
}

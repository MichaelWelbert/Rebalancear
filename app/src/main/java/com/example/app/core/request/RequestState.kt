package com.example.app.core.request

sealed class RequestState<T>{
    class Success<T>(val data: T? = null, val success: SuccessMessage? = null) : RequestState<T>()
    class Error<T>(val error: ErrorMessage) : RequestState<T>()
}
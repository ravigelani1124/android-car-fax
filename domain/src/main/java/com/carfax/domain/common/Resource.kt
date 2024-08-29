package com.carfax.domain.common

sealed class Resource<T>(
    val data: T? = null,
    val error: AppError? = null,
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(error: AppError, data: T? = null) : Resource<T>(data, error)
}

sealed interface AppError {
    data object NoInternet : AppError
    data class UnknownError(val throwable: Throwable) : AppError
    data class NetworkError(val code: Int, val message: String? = null) : AppError
}
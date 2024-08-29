package com.carfax.data.common

import com.carfax.domain.common.AppError
import com.carfax.domain.common.Resource
import kotlinx.coroutines.flow.*

internal inline fun <Result> networkBoundResource(
    crossinline cache: suspend () -> Flow<Result>,
    crossinline network: suspend () -> NetworkResponse<Result>,
    crossinline saveToCache: suspend (Result) -> Unit,
    crossinline shouldFetch: (Result) -> Boolean = { true },
) = flow {
    emit(Resource.Loading())
    val data = cache().first()
    val flow = if (shouldFetch(data)) {
        emit(Resource.Loading(data))
        try {
            when (val response = network()) {
                is NetworkResponse.ClientError -> cache().map {
                    Resource.Error(AppError.NetworkError(response.code, response.message), it)
                }

                is NetworkResponse.ServerError -> cache().map {
                    Resource.Error(AppError.NetworkError(response.code, response.message), it)
                }

                is NetworkResponse.NoInternet -> cache().map {
                    Resource.Error(AppError.NoInternet, it)
                }

                is NetworkResponse.Success -> {
                    saveToCache(response.response)
                    cache().map { Resource.Success(it) }
                }
            }
        } catch (throwable: Throwable) {
            cache().map { Resource.Error(AppError.UnknownError(throwable), it) }
        }
    } else {
        cache().map { Resource.Success(it) }
    }
    emitAll(flow)
}
package com.carfax.network.common

import com.carfax.data.common.NetworkResponse
import retrofit2.Response
import java.io.IOException

suspend fun <Out, In> retrofitApiCall(
    call: suspend () -> Response<In>,
    parse: suspend (In) -> Out,
): NetworkResponse<Out> {
    return try {
        val response = call()
        val body = response.body()
        val code = response.code()
        when {
            response.isSuccessful && body != null -> NetworkResponse.Success(parse(body))
            response.isSuccessful && body == null -> mapNetworkError(code, message = "No Body")

            else -> mapNetworkError(code, response.errorBody()?.string())
        }
    } catch (e: IOException) {
        NetworkResponse.NoInternet()
    } catch (e : Exception){
        NetworkResponse.NoInternet()
    }
}

private fun <T> mapNetworkError(code: Int, message: String? = null) =
    if (code in 399..499) NetworkResponse.ClientError<T>(code = code, message = message)
    else NetworkResponse.ServerError<T>(code = code, message = message)
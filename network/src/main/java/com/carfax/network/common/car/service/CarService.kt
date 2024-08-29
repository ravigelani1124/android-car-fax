package com.carfax.network.common.car.service

import com.carfax.network.common.NetworkConstants
import com.carfax.network.common.car.model.CarRemoteResponse
import retrofit2.Response
import retrofit2.http.GET

interface CarService {
    @GET(NetworkConstants.PATH_CARS)
    suspend fun get(): Response<CarRemoteResponse>
}


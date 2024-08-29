package com.carfax.data.car.datasource

import com.carfax.data.common.NetworkResponse
import com.carfax.domain.cars.model.Car
import kotlinx.coroutines.flow.Flow

interface CarCacheDataSource {
    suspend fun get(): Flow<List<Car>>
    suspend fun save(car: List<Car>)
}

interface CarNetworkDataSource {
    suspend fun get(): NetworkResponse<List<Car>>
}
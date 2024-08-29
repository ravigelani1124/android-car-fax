package com.carfax.domain.cars.repository

import com.carfax.domain.cars.model.Car
import com.carfax.domain.common.Resource
import kotlinx.coroutines.flow.Flow

interface CarsRepository {
    suspend fun get(): Flow<Resource<List<Car>>>
}
package com.carfax.domain.cars.usecase

import com.carfax.domain.cars.model.Car
import com.carfax.domain.common.Resource
import kotlinx.coroutines.flow.Flow

interface GetAvailableCarsUseCase {
    suspend operator fun invoke(): Flow<Resource<List<Car>>>
}
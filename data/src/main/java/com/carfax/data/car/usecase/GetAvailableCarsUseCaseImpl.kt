package com.carfax.data.car.usecase

import com.carfax.domain.cars.model.Car
import com.carfax.domain.cars.repository.CarsRepository
import com.carfax.domain.cars.usecase.GetAvailableCarsUseCase
import com.carfax.domain.common.Resource
import kotlinx.coroutines.flow.Flow

class GetAvailableCarsUseCaseImpl(private val carsRepository: CarsRepository) :
    GetAvailableCarsUseCase {
    override suspend fun invoke(): Flow<Resource<List<Car>>> {
       return carsRepository.get()
    }
}
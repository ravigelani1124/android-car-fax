package com.carfax.data.di

import com.carfax.data.car.repository.CarDataRepository
import com.carfax.data.car.usecase.GetAvailableCarsUseCaseImpl
import com.carfax.domain.cars.repository.CarsRepository
import com.carfax.domain.cars.usecase.GetAvailableCarsUseCase
import org.koin.dsl.module

private val car_module = module {
    factory<CarsRepository> { CarDataRepository(get(), get()) }
    factory<GetAvailableCarsUseCase> { GetAvailableCarsUseCaseImpl(get()) }
}

val data_modules = car_module
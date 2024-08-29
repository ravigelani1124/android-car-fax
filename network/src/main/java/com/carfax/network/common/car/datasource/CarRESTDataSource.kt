package com.carfax.network.common.car.datasource

import com.carfax.data.car.datasource.CarNetworkDataSource
import com.carfax.domain.cars.model.Car
import com.carfax.network.common.car.service.CarService
import com.carfax.network.common.retrofitApiCall

class CarRESTDataSource(private val service: CarService) :
    CarNetworkDataSource {
    override suspend fun get() = retrofitApiCall(
        call = { service.get() },
        parse = {
            it.listings.map { remote ->
                Car(
                    phone = remote.dealer?.phone,
                    vin = remote.vin,
                    mileage = remote.mileage,
                    currentPrice = remote.currentPrice,
                    interiorColor = remote.interiorColor,
                    exteriorColor = remote.exteriorColor,
                    engine = remote.engine,
                    driveType = remote.driveType,
                    transmission = remote.transmission,
                    bodyType = remote.bodyType,
                    image = remote.image?.firstPhoto?.large,
                    year = remote.year,
                    location = remote.dealer?.location,
                    make = remote.make,
                    model = remote.model,
                    trim = remote.trim
                )
            }
        }
    )
}
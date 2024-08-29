package com.carfax.cache.cars.datasource

import com.carfax.cache.cars.database.CarCache
import com.carfax.cache.cars.database.CarsDAO
import com.carfax.data.car.datasource.CarCacheDataSource
import com.carfax.domain.cars.model.Car
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class CarsRoomDataSource(
    private val dao: CarsDAO,
) : CarCacheDataSource {
    override suspend fun get(): Flow<List<Car>> {
        return dao.getAll().map { list ->
            list.map {
                Car(
                    phone = it.phone,
                    vin = it.vin,
                    mileage = it.mileage,
                    currentPrice = it.currentPrice,
                    interiorColor = it.interiorColor,
                    exteriorColor = it.exteriorColor,
                    engine = it.engine,
                    driveType = it.driveType,
                    transmission = it.transmission,
                    bodyType = it.bodyType,
                    image = it.image,
                    make = it.make,
                    model = it.model,
                    trim = it.trim,
                    location = it.location,
                    year = it.year
                )
            }
        }
    }

    override suspend fun save(car: List<Car>) {
        dao.deleteAll()
        dao.insertAll(
            car.map {
                CarCache(
                    phone = it.phone,
                    vin = it.vin,
                    mileage = it.mileage,
                    currentPrice = it.currentPrice,
                    interiorColor = it.interiorColor,
                    exteriorColor = it.exteriorColor,
                    engine = it.engine,
                    driveType = it.driveType,
                    transmission = it.transmission,
                    bodyType = it.bodyType,
                    image = it.image,
                    make = it.make,
                    model = it.model,
                    trim = it.trim,
                    location = it.location,
                    year = it.year
                )
            }
        )
    }
}
package com.carfax.data.car.repository

import com.carfax.data.car.datasource.CarCacheDataSource
import com.carfax.data.car.datasource.CarNetworkDataSource
import com.carfax.data.common.networkBoundResource
import com.carfax.domain.cars.model.Car
import com.carfax.domain.cars.repository.CarsRepository
import com.carfax.domain.common.Resource
import kotlinx.coroutines.flow.Flow

internal class CarDataRepository(
    private val cache: CarCacheDataSource,
    private val network: CarNetworkDataSource,
) : CarsRepository {
    override suspend fun get(): Flow<Resource<List<Car>>> {
        return networkBoundResource(
            cache = { cache.get() },
            network = { network.get() },
            saveToCache = { cache.save(it) }
        )
    }
}
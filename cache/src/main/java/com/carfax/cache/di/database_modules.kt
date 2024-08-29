package com.carfax.cache.di

import androidx.room.Room
import com.carfax.cache.cars.datasource.CarsRoomDataSource
import com.carfax.cache.common.AppDatabase
import com.carfax.cache.di.DatabaseConstants.DATABASE_NAME
import com.carfax.data.car.datasource.CarCacheDataSource
import org.koin.dsl.module

private val cars_database_module = module {
    factory { get<AppDatabase>().cars() }
    factory<CarCacheDataSource> { CarsRoomDataSource(get()) }
}
val database_modules = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
} + cars_database_module

internal object DatabaseConstants {
    const val DATABASE_NAME = "car-fax-database"
}
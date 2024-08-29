package com.carfax.cache.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.carfax.cache.cars.database.CarCache
import com.carfax.cache.cars.database.CarsDAO

@Database(entities = [CarCache::class], version = 1)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun cars(): CarsDAO
}
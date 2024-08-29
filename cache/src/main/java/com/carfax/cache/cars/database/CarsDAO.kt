package com.carfax.cache.cars.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
internal interface CarsDAO {
    @Query("SELECT * FROM cars")
    fun getAll(): Flow<List<CarCache>>

    @Insert
    suspend fun insertAll(cars: List<CarCache>)

    @Query("DELETE FROM cars")
    suspend fun deleteAll()
}
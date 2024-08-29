package com.carfax.cache.cars.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
internal data class CarCache(
    @PrimaryKey
    @ColumnInfo(name = "vin") val vin: String,
    @ColumnInfo(name = "phone") val phone: String?,
    @ColumnInfo(name = "mileage") val mileage: Long?,
    @ColumnInfo(name = "currentPrice") val currentPrice: Double?,
    @ColumnInfo(name = "exteriorColor") val exteriorColor: String?,
    @ColumnInfo(name = "interiorColor") val interiorColor: String?,
    @ColumnInfo(name = "engine") val engine: String?,
    @ColumnInfo(name = "driveType") val driveType: String?,
    @ColumnInfo(name = "transmission") val transmission: String?,
    @ColumnInfo(name = "bodyType") val bodyType: String?,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "year") val year: String?,
    @ColumnInfo(name = "make") val make: String?,
    @ColumnInfo(name = "model") val model: String?,
    @ColumnInfo(name = "trim") val trim: String?,
    @ColumnInfo(name = "location") val location: String?,
)
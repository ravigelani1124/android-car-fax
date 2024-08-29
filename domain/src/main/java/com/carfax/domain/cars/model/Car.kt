package com.carfax.domain.cars.model

data class Car(
    val phone: String?,
    val vin: String,
    val mileage: Long?,
    val currentPrice: Double?,
    val year: String?,
    val make: String?,
    val model: String?,
    val trim: String?,
    val location : String?,
    val exteriorColor: String?,
    val interiorColor: String?,
    val engine: String?,
    val driveType: String?,
    val transmission: String?,
    val bodyType: String?,
    val image: String?,
)
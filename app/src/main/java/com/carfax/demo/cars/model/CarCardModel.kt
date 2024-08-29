package com.carfax.demo.cars.model

import com.carfax.demo.common.toCurrency
import com.carfax.demo.common.toMileageString
import com.carfax.domain.cars.model.Car

data class CarCardModel(
    val vin: String,
    val image: String?,
    val title: String,
    val subtitle: String,
    val location: String,
    val phone: String,
)

fun Car.toCarModel() = CarCardModel(
    vin = this.vin,
    image = this.image,
    location = this.location.orEmpty(),
    phone = this.phone.orEmpty(),
    title = "${this.year.orEmpty()} ${this.make.orEmpty()} ${this.model.orEmpty()}",
    subtitle = "${this.currentPrice?.toCurrency()} | ${this.mileage?.toMileageString()}",
)
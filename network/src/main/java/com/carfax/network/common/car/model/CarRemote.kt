package com.carfax.network.common.car.model

import com.google.gson.annotations.SerializedName

data class CarRemoteResponse(
    @SerializedName("listings")
    val listings: List<CarRemote>,
)

data class CarRemote(
    @SerializedName("vin")
    val vin: String,
    @SerializedName("mileage")
    val mileage: Long?,
    @SerializedName("currentPrice")
    val currentPrice: Double?,
    @SerializedName("exteriorColor")
    val exteriorColor: String?,
    @SerializedName("interiorColor")
    val interiorColor: String?,
    @SerializedName("engine")
    val engine: String?,
    @SerializedName("drivetype")
    val driveType: String?,
    @SerializedName("transmission")
    val transmission: String?,
    @SerializedName("bodytype")
    val bodyType: String?,
    @SerializedName("images")
    val image: CarImages?,

    @SerializedName("year")
    val year: String?,
    @SerializedName("make")
    val make: String?,
    @SerializedName("model")
    val model: String?,
    @SerializedName("trim")
    val trim: String?,
    @SerializedName("dealer")
    val dealer: CarDealer?,
)

data class CarImages(
    @SerializedName("firstPhoto")
    val firstPhoto: CarLargeImage?,
)

data class CarLargeImage(
    @SerializedName("large")
    val large: String?,
)

data class CarDealer(
    @SerializedName("address")
    val location: String?,
    @SerializedName("phone")
    val phone: String?,
)
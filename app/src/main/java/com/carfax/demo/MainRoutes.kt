package com.carfax.demo

sealed class MainRoutes(val key: String) {
    data object CarList : MainRoutes("car_list")

    data class CarDetails(
        val vin: String? = null,
    ) : MainRoutes("car_details?vin={vin}") {
        val argumentRoute = "car_details" + "?" +
                "phone=$vin"
    }
}
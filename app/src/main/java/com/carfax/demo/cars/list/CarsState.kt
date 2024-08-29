package com.carfax.demo.cars.list

import androidx.annotation.StringRes
import com.carfax.demo.cars.model.CarCardModel
import com.carfax.domain.cars.model.Car
import io.uniflow.core.flow.data.UIState

data class CarsState(
    val loading: Boolean = false,
    @StringRes val error: Int? = null,
    val data: List<CarCardModel>? = null,
) : UIState()
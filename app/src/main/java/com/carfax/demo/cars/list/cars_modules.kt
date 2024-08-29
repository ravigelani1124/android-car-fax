package com.carfax.demo.cars.list

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val cars_ui_module = module {
    viewModelOf(::CarsViewModel)
}
package com.carfax.demo.di

import com.carfax.demo.cars.list.cars_ui_module
import com.carfax.di.common_modules


private val ui_modules = cars_ui_module


val di_modules = ui_modules + common_modules
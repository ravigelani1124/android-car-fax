package com.carfax.network.common.di

import com.carfax.data.car.datasource.CarNetworkDataSource
import com.carfax.network.common.NetworkConstants
import com.carfax.network.common.car.datasource.CarRESTDataSource
import com.carfax.network.common.car.service.CarService
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val car_network_module = module {
    factory { get<Retrofit>().create(CarService::class.java) }
    factory<CarNetworkDataSource> { CarRESTDataSource(get()) }
}

val network_module = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor.Builder(get()).build())
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .client(get())
            .addConverterFactory(get())
            .build()
    }
    single<Converter.Factory> { GsonConverterFactory.create() }
} + car_network_module
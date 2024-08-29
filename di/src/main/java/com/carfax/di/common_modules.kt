package com.carfax.di

import com.carfax.cache.di.database_modules
import com.carfax.data.di.data_modules
import com.carfax.network.common.di.network_module

val common_modules = data_modules + database_modules + network_module
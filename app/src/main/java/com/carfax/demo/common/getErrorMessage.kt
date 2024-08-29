package com.carfax.demo.common

import com.carfax.demo.R
import com.carfax.domain.common.AppError

fun AppError.getErrorMessage() = when (this) {
    AppError.NoInternet -> R.string.error_no_internet
    is AppError.NetworkError -> R.string.network_error
    is AppError.UnknownError -> R.string.unknown_error
}
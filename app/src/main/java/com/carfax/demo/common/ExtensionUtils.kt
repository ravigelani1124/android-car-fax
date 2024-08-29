package com.carfax.demo.common

import android.icu.text.NumberFormat
import android.icu.util.Currency
import java.util.Locale

fun Double?.toCurrency(): String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
    format.maximumFractionDigits = 2
    format.currency = Currency.getInstance("USD")
    return this?.let { format.format(this) }.orEmpty()
}

fun Long.toMileageString(): String {
    return when {
        this >= 1_000_000 -> String.format("%.1fm", this / 1_000_000.0)
        this >= 1_000 -> String.format("%.1fk", this / 1_000.0)
        else -> this.toString()
    }
}
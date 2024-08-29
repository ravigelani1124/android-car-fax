package com.carfax.demo

import android.app.Application
import com.carfax.demo.di.di_modules
import io.uniflow.core.logger.DebugMessageLogger
import io.uniflow.core.logger.UniFlowLogger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CarFaxApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CarFaxApplication)
            androidLogger(Level.INFO)
            modules(di_modules)
        }
        UniFlowLogger.init(DebugMessageLogger())
    }
}
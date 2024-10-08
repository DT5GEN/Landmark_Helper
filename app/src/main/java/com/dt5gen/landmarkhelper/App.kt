package com.dt5gen.landmarkhelper

import android.app.Application
import com.dt5gen.landmarkhelper.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // Инициализация Koin
        startKoin {
            // Передаем контекст приложения
            androidContext(this@App)
            // Загружаем модуль
            modules(appModule)
        }
    }
}
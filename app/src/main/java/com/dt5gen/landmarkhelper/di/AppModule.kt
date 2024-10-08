package com.dt5gen.landmarkhelper.di

import com.dt5gen.landmarkhelper.network.ApiService
import com.dt5gen.landmarkhelper.network.ApiServiceImpl
import com.dt5gen.landmarkhelper.network.RetrofitClient
import com.dt5gen.landmarkhelper.viewmodel.LandmarkViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Здесь мы регистрируем Retrofit клиент
    single<ApiService> { RetrofitClient.apiService }

    // Регистрируем реализацию ApiServiceImpl
    single { ApiServiceImpl(get()) }

    // Определяем ViewModel, который использует ApiServiceImpl
    viewModel { LandmarkViewModel(get()) }
}
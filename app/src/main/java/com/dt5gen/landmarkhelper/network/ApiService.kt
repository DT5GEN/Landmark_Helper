package com.dt5gen.landmarkhelper.network

import com.dt5gen.landmarkhelper.model.Landmark
import com.dt5gen.landmarkhelper.model.Locality
import com.dt5gen.landmarkhelper.model.Services
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("/landmark")
    suspend fun getLandmarks(): List<Landmark>

    @GET("/locality")
    suspend fun getLocality(): List<Locality>

    @GET("/services")
    suspend fun getServices(): List<Services>
}

object RetrofitClient {
    private const val BASE_URL = "http://192.168.0.243:8080/api/" // Заменить на актуальный URL

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
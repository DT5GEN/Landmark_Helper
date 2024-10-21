package com.dt5gen.landmarkhelper.network

import com.dt5gen.landmarkhelper.model.LandmarkDTO
import com.dt5gen.landmarkhelper.model.LocalityDTO
import com.dt5gen.landmarkhelper.model.ServicesDTO
import retrofit2.http.GET

interface ApiService {
    @GET("landmarks")
    suspend fun getLandmarks(): List<LandmarkDTO>

    @GET("localities")
    suspend fun getLocality(): List<LocalityDTO>

    @GET("services")
    suspend fun getServices(): List<ServicesDTO>
}


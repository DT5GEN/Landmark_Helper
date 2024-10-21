package com.dt5gen.landmarkhelper.network

import com.dt5gen.landmarkhelper.model.Landmark
import com.dt5gen.landmarkhelper.model.Locality
import com.dt5gen.landmarkhelper.model.Services
import retrofit2.http.GET

interface ApiService {
    @GET("landmarks")
    suspend fun getLandmarks(): List<Landmark>

    @GET("localities")
    suspend fun getLocality(): List<Locality>

    @GET("services")
    suspend fun getServices(): List<Services>
}


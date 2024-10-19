package com.dt5gen.landmarkhelper.network

import com.dt5gen.landmarkhelper.model.Landmark
import com.dt5gen.landmarkhelper.model.Locality
import com.dt5gen.landmarkhelper.model.Services
import retrofit2.http.GET

interface ApiService {
    @GET("landmark")
    suspend fun getLandmarks(): List<Landmark>

    @GET("locality")
    suspend fun getLocality(): List<Locality>

    @GET("services")
    suspend fun getServices(): List<Services>
}


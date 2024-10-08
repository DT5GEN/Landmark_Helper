package com.dt5gen.landmarkhelper.network

import com.dt5gen.landmarkhelper.model.Landmark
import com.dt5gen.landmarkhelper.model.Locality
import com.dt5gen.landmarkhelper.model.Services

class ApiServiceImpl(private val apiService: ApiService) : ApiService {

    override suspend fun getLandmarks(): List<Landmark> {
        // Здесь мы вызываем метод из интерфейса ApiService, который использует Retrofit
        return apiService.getLandmarks()
    }

    override suspend fun getLocality(): List<Locality> {
        // Вызываем метод, который возвращает список местоположений
        return apiService.getLocality()
    }

    override suspend fun getServices(): List<Services> {
        // Вызываем метод, который возвращает список услуг
        return apiService.getServices()
    }
}
package com.dt5gen.landmarkhelper.network

import com.dt5gen.landmarkhelper.model.LandmarkDTO
import com.dt5gen.landmarkhelper.model.LocalityDTO
import com.dt5gen.landmarkhelper.model.ServicesDTO

class ApiServiceImpl(private val apiService: ApiService) : ApiService {

    override suspend fun getLandmarks(): List<LandmarkDTO> {
        // Здесь мы вызываем метод из интерфейса ApiService, который использует Retrofit
        return apiService.getLandmarks()
    }

    override suspend fun getLocality(): List<LocalityDTO> {
        // Вызываем метод, который возвращает список местоположений
        return apiService.getLocality()
    }

    override suspend fun getServices(): List<ServicesDTO> {
        // Вызываем метод, который возвращает список услуг
        return apiService.getServices()
    }
}
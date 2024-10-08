package com.dt5gen.landmarkhelper.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dt5gen.landmarkhelper.model.Services
import com.dt5gen.landmarkhelper.network.ApiService
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ServicesViewModel(private val apiService: ApiService) : ViewModel() {

    private val _services = MutableStateFlow<List<Services>>(emptyList())
    val services: StateFlow<List<Services>> = _services

    fun fetchServices() {
        viewModelScope.launch {
            try {
                val response = apiService.getServices()
                _services.value = response
            } catch (e: Exception) {
                // Обработка ошибок
            }
        }
    }
}
package com.dt5gen.landmarkhelper.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dt5gen.landmarkhelper.model.ServicesDTO
import com.dt5gen.landmarkhelper.network.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ServicesViewModel(private val apiService: ApiService) : ViewModel() {

    private val _servicesDTO = MutableStateFlow<List<ServicesDTO>>(emptyList())
    val servicesDTO: StateFlow<List<ServicesDTO>> = _servicesDTO

    fun fetchServices() {
        viewModelScope.launch {
            try {
                val response = apiService.getServices()
                _servicesDTO.value = response
            } catch (e: Exception) {
                // Обработка ошибок
            }
        }
    }
}
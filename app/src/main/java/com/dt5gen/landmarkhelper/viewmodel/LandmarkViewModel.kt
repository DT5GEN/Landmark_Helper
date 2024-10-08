package com.dt5gen.landmarkhelper.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dt5gen.landmarkhelper.model.Landmark
import com.dt5gen.landmarkhelper.network.ApiService
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LandmarkViewModel(private val apiService: ApiService) : ViewModel() {

    private val _landmarks = MutableStateFlow<List<Landmark>>(emptyList())
    val landmarks: StateFlow<List<Landmark>> = _landmarks

    fun fetchLandmarks() {
        viewModelScope.launch {
            try {
                val response = apiService.getLandmarks()
                _landmarks.value = response
            } catch (e: Exception) {
                // Обработка ошибки
            }
        }
    }
}
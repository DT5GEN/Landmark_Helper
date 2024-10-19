package com.dt5gen.landmarkhelper.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dt5gen.landmarkhelper.model.Landmark
import com.dt5gen.landmarkhelper.network.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LandmarkViewModel(private val apiService: ApiService) : ViewModel() {

    val isLoading = MutableStateFlow(false)
    val errorMessage = MutableStateFlow<String?>(null)
    private val _landmarks = MutableStateFlow<List<Landmark>>(emptyList())
    val landmarks: StateFlow<List<Landmark>> = _landmarks

    fun fetchLandmarks() {
        viewModelScope.launch {
            isLoading.value = true
            errorMessage.value = null
            try {
                val response = apiService.getLandmarks()
                _landmarks.value = response
                Log.d("LandmarkViewModel", "Fetched landmarks: $response") // Лог успешного получения данных
            } catch (e: Exception) {
                errorMessage.value = "Failed to load landmarks"
                Log.e("LandmarkViewModel", "Error fetching landmarks", e) // Лог ошибки
            } finally {
                isLoading.value = false
            }
        }
    }
}


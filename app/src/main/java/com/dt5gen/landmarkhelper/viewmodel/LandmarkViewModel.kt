package com.dt5gen.landmarkhelper.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dt5gen.landmarkhelper.model.Landmark
import com.dt5gen.landmarkhelper.network.ApiService
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LandmarkViewModel(private val apiService: ApiService) : ViewModel() {

    val isLoading = MutableStateFlow(false)
    val errorMessage = MutableStateFlow<String?>(null)
    private val _landmarks = MutableStateFlow<List<Landmark>>(emptyList())
    val landmarks: StateFlow<List<Landmark>> = _landmarks

    fun fetchLandmarks() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val response = apiService.getLandmarks()
                _landmarks.value = response
                errorMessage.value = null
            } catch (e: Exception) {
                errorMessage.value = e.message
            } finally {
                isLoading.value = false
            }
        }
    }
}
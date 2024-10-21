package com.dt5gen.landmarkhelper.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dt5gen.landmarkhelper.model.LocalityDTO
import com.dt5gen.landmarkhelper.network.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocalityViewModel(private val apiService: ApiService) : ViewModel() {

    val isLoading = MutableStateFlow(false)
    val errorMessage = MutableStateFlow<String?>(null)

    private val _localities = MutableStateFlow<List<LocalityDTO>>(emptyList())
    val localities: StateFlow<List<LocalityDTO>> = _localities



    fun fetchLocalities() {
        viewModelScope.launch {
            isLoading.value = true
            errorMessage.value = null
            try {
                val response = apiService.getLocality()
                _localities.value = response
                Log.d(
                    "LocalityViewModel",
                    "Fetched landmarks: $response"
                ) // Лог успешного получения данных
            } catch (e: Exception) {
                errorMessage.value = "Failed to load landmarks"
                Log.e("LocalityViewModel", "Error fetching landmarks", e) // Лог ошибки
            } finally {
                isLoading.value = false
            }
        }
    }
}
package com.dt5gen.landmarkhelper.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dt5gen.landmarkhelper.model.Locality
import com.dt5gen.landmarkhelper.network.ApiService
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LocalityViewModel(private val apiService: ApiService) : ViewModel() {

    private val _localities = MutableStateFlow<List<Locality>>(emptyList())
    val localities: StateFlow<List<Locality>> = _localities

    fun fetchLocalities() {
        viewModelScope.launch {
            try {
                val response = apiService.getLocality()
                _localities.value = response
            } catch (e: Exception) {
                // Обработка ошибок
            }
        }
    }
}
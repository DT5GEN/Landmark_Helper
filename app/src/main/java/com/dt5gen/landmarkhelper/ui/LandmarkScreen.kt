package com.dt5gen.landmarkhelper.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dt5gen.landmarkhelper.model.LandmarkDTO
import com.dt5gen.landmarkhelper.network.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

// В LandmarkViewModel добавим состояния загрузки и ошибки
class LandmarkViewModel(private val apiService: ApiService) : ViewModel() {

    private val _landmarks = MutableStateFlow<List<LandmarkDTO>>(emptyList())
    val landmarks: StateFlow<List<LandmarkDTO>> = _landmarks

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchLandmarks() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val response = apiService.getLandmarks()
                _landmarks.value = response
                Log.d("LandmarkViewModel", "Fetched landmarks: $response") // Лог успешного получения данных
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load landmarks"
                Log.e("LandmarkViewModel", "Error fetching landmarks", e) // Лог ошибки
            } finally {
                _isLoading.value = false
            }
        }
    }
}

// Обновим код LandmarkScreen для обработки новых состояний
@Composable
fun LandmarkScreen(viewModel: com.dt5gen.landmarkhelper.ui.LandmarkViewModel = koinViewModel()) {
    val landmarks = viewModel.landmarks.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()
    val errorMessage = viewModel.errorMessage.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Landmarks", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading.value) {
            Text(text = "Loading...", style = MaterialTheme.typography.bodyLarge)
        } else if (errorMessage.value != null) {
            Text(text = errorMessage.value ?: "Unknown error", color = MaterialTheme.colorScheme.error)
        } else {
            LazyColumn {
                items(landmarks.value) { landmark ->
                    LandmarkItem(landmark)
                }
            }
        }
    }
}


// Вызов fetchLandmarks() при загрузке экрана
@Composable
fun LandmarkScreenContent(viewModel: com.dt5gen.landmarkhelper.ui.LandmarkViewModel = koinViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.fetchLandmarks()
        Log.d("fetch5", "LandmarkScreenContent: ")
    }
    LandmarkScreen(viewModel)
}

@Composable

fun LandmarkItem(landmarkDTO: LandmarkDTO) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = landmarkDTO.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = landmarkDTO.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
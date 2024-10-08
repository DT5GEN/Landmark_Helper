package com.dt5gen.landmarkhelper.ui



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dt5gen.landmarkhelper.model.Landmark
import com.dt5gen.landmarkhelper.viewmodel.LandmarkViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun LandmarkScreen(viewModel: LandmarkViewModel = koinViewModel()) {
    val landmarks = viewModel.landmarks.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Landmarks", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(landmarks.value) { landmark ->
                LandmarkItem(landmark)
            }
        }
    }
}

@Composable
fun LandmarkItem(landmark: Landmark) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = landmark.name, style = MaterialTheme.typography.titleLarge)
            Text(text = landmark.description)
        }
    }
}
package com.dt5gen.landmarkhelper.ui


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dt5gen.landmarkhelper.model.Locality
import com.dt5gen.landmarkhelper.viewmodel.LocalityViewModel

@Composable
fun LocalityScreen(viewModel: LocalityViewModel = viewModel()) {
    val localities = viewModel.localities.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Localities", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(localities.value) { locality ->
                LocalityItem(locality)
            }
        }
    }
}

@Composable
fun LocalityItem(locality: Locality) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = locality.name, style = MaterialTheme.typography.titleLarge)
            Text(text = locality.region)
        }
    }
}
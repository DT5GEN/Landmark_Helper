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
import com.dt5gen.landmarkhelper.model.Services
import com.dt5gen.landmarkhelper.viewmodel.ServicesViewModel

@Composable
fun ServiceScreen(viewModel: ServicesViewModel = viewModel()) {
    val services = viewModel.services.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Services", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(services.value) { service ->
                ServiceItem(service)
            }
        }
    }
}

@Composable
fun ServiceItem(service: Services) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = service.name, style = MaterialTheme.typography.titleLarge)
            Text(text = service.category)
        }
    }
}
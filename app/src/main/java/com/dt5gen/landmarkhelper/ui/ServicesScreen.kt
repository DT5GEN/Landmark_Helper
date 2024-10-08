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
import com.dt5gen.landmarkhelper.model.Services
import com.dt5gen.landmarkhelper.viewmodel.ServicesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ServiceScreen(viewModel: ServicesViewModel = koinViewModel()) {
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
package com.dt5gen.landmarkhelper.navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
//import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavHost
import com.dt5gen.landmarkhelper.ui.LandmarkScreen
import com.dt5gen.landmarkhelper.ui.LocalityScreen
import com.dt5gen.landmarkhelper.ui.ServiceScreen
import java.util.Locale

import androidx.navigation.compose.NavHost
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.composable

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("landmarks", "Landmarks", Icons.Filled.Place),
        BottomNavItem("locality", "Locality", Icons.Filled.Home),
        BottomNavItem("services", "Services", Icons.Filled.Settings)
    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                label = { Text(item.label) },
                icon = { Icon(item.icon, contentDescription = item.label) },
                selected = false,  // Логику выбора можно настроить позже
                onClick = {
                    navController.navigate(item.route)
                }
            )
        }
    }
}

@Composable
fun AppScaffold(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "landmarks",  // Указываем начальный экран
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("landmarks") { LandmarkScreen() }
            composable("locality") { LocalityScreen() }
            composable("services") { ServiceScreen() }
        }
    }
}

data class BottomNavItem(val route: String, val label: String, val icon: ImageVector)
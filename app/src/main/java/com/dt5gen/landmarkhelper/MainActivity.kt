package com.dt5gen.landmarkhelper


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.dt5gen.landmarkhelper.navigation.AppScaffold
import com.dt5gen.landmarkhelper.ui.theme.LandmarkHelperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LandmarkHelperTheme {
                val navController = rememberNavController()
                AppScaffold(navController = navController) // Передаём navController в AppScaffold
            }
        }
    }
}
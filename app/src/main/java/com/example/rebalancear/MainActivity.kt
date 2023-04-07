package com.example.rebalancear


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.compose.rememberNavController
import com.example.pendulum.ui.theme.RebalanceTheme
import com.example.rebalancear.routes.MakeRoutes
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RebalanceTheme {
                val navHostController = rememberNavController()
                MakeRoutes(navController = navHostController)
            }
        }
    }
}

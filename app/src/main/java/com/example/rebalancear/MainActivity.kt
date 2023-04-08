package com.example.rebalancear


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.compose.rememberNavController
import com.example.rebalancear.ui.theme.RebalanceTheme
import com.example.rebalancear.routes.MakeRoutes
import dagger.hilt.android.AndroidEntryPoint


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

package com.example.rebalancear


import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rebalancear.presentation.adsense.IAdSense
import com.example.rebalancear.presentation.adsense.RouteTriggeredAdDisplay
import com.example.rebalancear.presentation.ui.theme.RebalanceColors
import com.example.rebalancear.presentation.ui.theme.RebalanceTheme
import com.example.rebalancear.routes.MakeRoutes
import com.example.rebalancear.routes.Routes
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var adsense: IAdSense

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            RebalanceTheme {
                MakeRoutes(
                    navController = navController,
                    { route ->
                        RouteTriggeredAdDisplay.onRouteSwitch(
                            route = route,
                            adsense = adsense,
                            activity = this
                        )
                    },
                    adSense = adsense,
                )
            }

            ExitAppOnBackPressedWhenEmptyBackStack(navController)
        }

        changeSystemBarColors(RebalanceColors.primaryColor)
    }

    @Composable
    private fun ExitAppOnBackPressedWhenEmptyBackStack(navController: NavHostController) {
        BackHandler {
            if (!navController.popBackStack()) {
                this.finish()
            }
        }
    }

    private fun changeSystemBarColors(color: Color) {
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.navigationBarColor = color.hashCode()
        window.statusBarColor = color.hashCode()
    }
}

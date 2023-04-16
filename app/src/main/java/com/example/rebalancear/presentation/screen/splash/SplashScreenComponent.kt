package com.example.rebalancear.presentation.screen.splash

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rebalancear.presentation.ui.theme.ReBalanceTypography
import com.example.rebalancear.presentation.ui.theme.RebalanceColors
import com.example.rebalancear.routes.Routes
import kotlinx.coroutines.delay

@Composable
internal fun SplashScreenComponent(navController: NavController) {
    var startAnimation by remember { mutableStateOf(Status.HIDE) }
    val alphaAnimation = animateFloatAsState(
        targetValue = when (startAnimation) {
            Status.HIDE -> 0f
            Status.ENABLE -> 1f
            Status.DISABLE -> 0f
        },
        animationSpec = tween(durationMillis = 2000)
    )

    Splash(alpha = alphaAnimation.value)

    LaunchedEffect(key1 = true) {
        startAnimation = Status.ENABLE
        delay(2000)
        startAnimation = Status.DISABLE
        delay(1000)
        navController.popBackStack()
        navController.navigate(Routes.WalletScreen.route)

    }


}

internal enum class Status {
    HIDE,
    ENABLE,
    DISABLE
}

@Composable
internal fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(RebalanceColors.whiteColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.alpha(alpha),
            text = "BALANCE",
            color = RebalanceColors.primaryColor,
            style = ReBalanceTypography.Tittle.copy(fontSize = 50.sp, letterSpacing = 5.sp),
        )
    }
}
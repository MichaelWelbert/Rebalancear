package com.example.app.presentation.ui.components.assets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.presentation.theme.Colors
import com.example.rebalancear.presentation.ui.theme.style
import kotlin.math.round

@Composable
fun Progress(
    percentGoal: Float,
    percentOwned: Float,
    textGoalColor: Color = Colors.whiteColor,
    textOwnedColor: Color = Colors.whiteColor,
    backgroundColor: Color = Colors.blackColor,
    progressColor: Color = Colors.pinkColor,
) {
    val progress = progress(percentOwned, percentGoal)


    Box(
        Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {

        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(backgroundColor, shape = RoundedCornerShape(35.dp)),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                modifier = Modifier.padding(end = 15.dp),
                text = round((percentGoal * 100)).toInt().toString() + "%",
                color = textGoalColor,
                style = style.Body4
            )
        }

        Box(
            Modifier
                .fillMaxWidth(progress)
                .height(50.dp)
                .background(progressColor, shape = RoundedCornerShape(35.dp)),
            contentAlignment = Alignment.CenterEnd

        ) {
            Text(
                modifier = Modifier.padding(end = 15.dp),
                text = round((percentOwned * 100)).toInt().toString() + "%",
                color = textOwnedColor,
                style = style.Body4
            )

        }
    }


}


private fun progress(owned: Float, goal: Float): Float {

    if (owned >= goal)
        return 1f

    val progress = owned / goal

    if (progress < 0.05)
        return 0f

    if (progress >= 0.95)
        return 1f


    val minSizeProgressBar = 0.15f

    if (progress < minSizeProgressBar)
        return minSizeProgressBar

    val maxSizeProgressBar = 0.85f

    if (progress > maxSizeProgressBar)
        return maxSizeProgressBar

    return progress
}


@Preview
@Composable
fun preview() {
    Progress(0.5f, 0.5f)
}
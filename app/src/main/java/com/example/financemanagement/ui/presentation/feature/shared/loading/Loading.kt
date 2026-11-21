package com.example.financemanagement.ui.presentation.feature.shared.loading

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financemanagement.R
import com.example.financemanagement.ui.theme.FinanceManagementTheme
import com.example.financemanagement.ui.theme.FinanceTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Preview
@Composable
private fun PreviewLoading() {
    FinanceManagementTheme() {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            LoadingState()
        }
    }
}

@Composable
fun LoadingState(
    modifier: Modifier = Modifier,
    error: Boolean = false,
    check: Boolean = false
) {
   when{
       error -> LoadingItem(
           modifier = modifier
       ) {
           Icon(
               imageVector = ImageVector.vectorResource(R.drawable.ic_error_loading),
               contentDescription = null,
               tint = Color.Unspecified
           )
       }
       check -> LoadingItem(
           modifier = modifier
       ) {
           Icon(
               imageVector = ImageVector.vectorResource(R.drawable.ic_check_loading),
               contentDescription = null,
               tint = Color.Unspecified
           )
       }
       else -> Loading(modifier = modifier)
   }
}

@Composable
fun Loading(
    modifier: Modifier = Modifier
) {
    val circleCount = 3
    val animations = List(circleCount) {
        remember { Animatable(0f) }
    }

    LaunchedEffect(Unit) {
        while (true) {
            animations[0].animateTo(
                targetValue = 1f,
                animationSpec = tween(300)
            )

            animations[1].animateTo(
                targetValue = 1f,
                animationSpec = tween(300)
            )

            animations[2].animateTo(
                targetValue = 1f,
                animationSpec = tween(300)
            )

            delay(400.milliseconds)

            animations.forEach { animatable ->
                animatable.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(300)
                )
            }

            delay(200.milliseconds)
        }
    }

    LoadingItem(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            animations.forEachIndexed { index, animatable ->
                val alpha = animatable.value

                Box(
                    modifier = Modifier
                        .size(13.dp)
                        .background(
                            color = FinanceTheme.lightGreen.copy(alpha = alpha),
                            shape = CircleShape
                        )
                )
            }
        }
    }
}

@Composable
fun LoadingItem(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .size(100.dp)
            .border(
                width = 7.dp,
                color = Color.White,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

data class Loading(
    val color: Color
)
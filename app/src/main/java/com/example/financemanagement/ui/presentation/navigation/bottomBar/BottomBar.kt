package com.example.financemanagement.ui.presentation.navigation.bottomBar


import android.os.Build
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.financemanagement.R
import com.example.financemanagement.ui.presentation.approutes.AppRoutes
import com.example.financemanagement.ui.theme.FinanceTheme
import android.graphics.ColorMatrix as AndroidColorMatrix
import android.graphics.ColorMatrixColorFilter as AndroidColorMatrixColorFilter
import android.graphics.RenderEffect as AndroidRenderEffect
import android.graphics.Shader as AndroidShader

data class BottomBarBtn(
    val icon: Int,
    val navGraph: String
)


@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val items = listOf(
        BottomBarBtn(icon = R.drawable.ic_home_navigation, navGraph = AppRoutes.HOME),
        BottomBarBtn(icon = R.drawable.ic_analysis_navigation, navGraph = AppRoutes.ANALYSIS),
        BottomBarBtn(icon = R.drawable.ic_transactions_navigation, navGraph = AppRoutes.TRANSACTIONS),
        BottomBarBtn(icon = R.drawable.ic_category_navigation, navGraph = AppRoutes.CATEGORIES),
        BottomBarBtn(icon = R.drawable.ic_profile_navigation, navGraph = AppRoutes.PROFILE),
    )
    var selectedIndex by remember { mutableIntStateOf(0) }

    val tabPositions = remember {
        mutableStateListOf<Float>().apply { repeat(items.size) { add(0f) } }
    }

    val density = LocalDensity.current
    val boxWidth = 57.dp
    val boxHeight = 53.dp
    val boxWidthPx = with(density) { boxWidth.toPx() }

    val targetX = tabPositions.getOrNull(selectedIndex) ?: 0f
    val animatedX by animateFloatAsState(
        targetValue = targetX,
        animationSpec = tween(durationMillis = 400)
    )

    val gooeyMatrix = AndroidColorMatrix(
        floatArrayOf(
            1f, 0f, 0f, 0f, 0f,
            0f, 1f, 0f, 0f, 0f,
            0f, 0f, 1f, 0f, 0f,
            0f, 0f, 0f, 50f, -2000f
        )
    )
    val nativeColorFilter = AndroidColorMatrixColorFilter(gooeyMatrix)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(108.dp)
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(topStartPercent = 60, topEndPercent = 60)
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        val blurEffect = AndroidRenderEffect.createBlurEffect(
                            30f, 30f, AndroidShader.TileMode.CLAMP
                        )
                        val filterEffect = AndroidRenderEffect.createColorFilterEffect(nativeColorFilter)
                        val chainEffect = AndroidRenderEffect.createChainEffect(filterEffect, blurEffect)
                        renderEffect = chainEffect.asComposeRenderEffect()
                    }
                }
        ) {
            if (tabPositions.any { it > 0f }) {
                Box(
                    modifier = Modifier
                        .offset(x = with(density) { animatedX.toDp() })
                        .size(boxWidth, boxHeight)
                        .align(Alignment.CenterStart)
                        .background(FinanceTheme.mainGreen, shape = RoundedCornerShape(22.dp))
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp, end = 60.dp, bottom = 41.dp, start = 60.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = selectedIndex == index

                Icon(
                    imageVector = ImageVector.vectorResource(item.icon),
                    contentDescription = null,
                    tint = if (isSelected) FinanceTheme.backDarkMode
                    else MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .onGloballyPositioned { coordinates ->
                            val root = coordinates.parentLayoutCoordinates?.parentLayoutCoordinates
                            val iconLeftInRoot = root
                                ?.localPositionOf(coordinates, Offset.Zero)
                                ?.x ?: 0f
                            val iconWidth = coordinates.size.width

                            tabPositions[index] = iconLeftInRoot + iconWidth / 2f - boxWidthPx / 2f
                        }
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            selectedIndex = index
                            navController.navigate(item.navGraph)
                        }
                )
            }
        }
    }
}
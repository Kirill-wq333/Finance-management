package com.example.financemanagement.ui.presentation.navigation

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.RenderEffect as AndroidRenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financemanagement.R

@Preview
@Composable
private fun PreviewTab() {
    var currentTab by remember { mutableStateOf(0) }

    LiquidBottomBar(
        currentTab = currentTab,
        onTabSelected = { currentTab = it }
    )
}


// Модель данных для таба
data class NavigationItem(
    val icon: ImageVector,
    val label: String
)

@Composable
fun LiquidBottomBar(
    currentTab: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    // Список ваших табов (для примера взяты стандартные иконки)
    val items = listOf(
        NavigationItem(ImageVector.vectorResource(R.drawable.ic_home_navigation), "Главная"),
        NavigationItem(ImageVector.vectorResource(R.drawable.ic_transactions_navigation), "Настройки"),
        NavigationItem(ImageVector.vectorResource(R.drawable.ic_analysis_navigation), "Профиль")
    )

    // Конфигурация эффекта размытия для создания эффекта жидких капель (метаболлов)
    val liquidModifier = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        Modifier.graphicsLayer {
            val blur = AndroidRenderEffect.createBlurEffect(40f, 40f, Shader.TileMode.CLAMP)

            val alphaMatrix = ColorMatrix(floatArrayOf(
                1f, 0f, 0f, 0f, 0f,
                0f, 1f, 0f, 0f, 0f,
                0f, 0f, 1f, 0f, 0f,
                0f, 0f, 0f, 60f, -1500f // Экстремальный контраст убирает полупрозрачное размытие
            ))
            val filter = AndroidRenderEffect.createColorFilterEffect(ColorMatrixColorFilter(alphaMatrix))
            val nativeChainEffect = AndroidRenderEffect.createChainEffect(filter, blur)

            // Исправленная конвертация типа из Android SDK в AndroidX Compose
            renderEffect = nativeChainEffect.asComposeRenderEffect()
        }
    } else {
        Modifier
    }

    // Измеряем ширину экрана, чтобы точно рассчитать координаты капли
    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp) // Общая высота компонента (с учетом вылетающей капли)
            .background(Color.Transparent)
    ) {
        val density = LocalDensity.current
        val maxWidthPx = with(density) { maxWidth.toPx() }
        val itemCount = items.size

        // Расчет X-координаты для центра каждого таба
        val tabWidthPx = maxWidthPx / itemCount
        val targetXFloat = (currentTab * tabWidthPx) + (tabWidthPx / 2f)

        // Анимация плавного перемещения жидкой капли по горизонтали
        val animatedXPx by animateFloatAsState(
            targetValue = targetXFloat,
            animationSpec = tween(durationMillis = 400),
            label = "LiquidBlobAnimation"
        )
        val animatedXDp = with(density) { animatedXPx.toDp() }

        // Жидкий фоновый слой (на нем применяется RenderEffect)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(liquidModifier)
                .background(Color.Transparent)
        ) {
            // Главная горизонтальная плашка BottomBar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .align(Alignment.BottomCenter)
                    .background(Color.Black) // Цвет вашей панели
            )

            // Выступающая капля, которая сливается со статичной плашкой
            Box(
                modifier = Modifier
                    .size(60.dp)
                    // Сдвигаем каплю в точку анимированной координаты (с учетом её собственного радиуса)
                    .offset(x = animatedXDp - 30.dp, y = 10.dp)
                    .background(Color.Black, shape = CircleShape)
            )
        }

        // Интерактивный верхний слой (чистые кликабельные элементы и иконки)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = currentTab == index

                // Анимация выталкивания иконки вверх при активации таба
                val iconOffsetY by animateFloatAsState(
                    targetValue = if (isSelected) -20f else 0f,
                    animationSpec = tween(durationMillis = 350),
                    label = "IconElevationAnimation"
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(65.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null // Отключаем стандартный ripple-эффект, чтобы не портить жидкий визуал
                        ) {
                            onTabSelected(index)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        // Цвет активной иконки делаем белым, неактивной — серым
                        tint = if (isSelected) Color.White else Color.Gray,
                        modifier = Modifier
                            .size(26.dp)
                            .offset(y = iconOffsetY.dp)
                    )
                }
            }
        }
    }
}

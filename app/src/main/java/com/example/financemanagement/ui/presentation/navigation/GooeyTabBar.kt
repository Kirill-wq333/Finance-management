package com.example.financemanagement.ui.presentation.navigation

import android.R
import android.os.Build
import android.graphics.ColorMatrix as AndroidColorMatrix
import android.graphics.ColorMatrixColorFilter as AndroidColorMatrixColorFilter
import android.graphics.RenderEffect as AndroidRenderEffect
import android.graphics.Shader as AndroidShader
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun GooeyTabBar() {
    val items = listOf("Home", "Stats", "Exchange", "Layers", "Profile")
    var selectedIndex by remember { mutableStateOf(0) }

    // Храним X-координаты для каждого таба
    val tabPositions = remember { mutableStateListOf<Float>() }
    if (tabPositions.isEmpty()) {
        repeat(items.size) { tabPositions.add(0f) }
    }

    val density = LocalDensity.current

    // Анимируем позицию капли по оси X
    val targetX = tabPositions.getOrNull(selectedIndex) ?: 0f
    val animatedX by animateFloatAsState(
        targetValue = targetX,
        animationSpec = tween(durationMillis = 400) // Скорость перетекания капли
    )

    // Нативная цветовая матрица для сильного повышения контраста альфа-канала
    // Именно она «склеивает» размытые края в четкую каплю жидкости
    val gooeyMatrix = AndroidColorMatrix(floatArrayOf(
        1f, 0f, 0f, 0f, 0f,       // R
        0f, 1f, 0f, 0f, 0f,       // G
        0f, 0f, 1f, 0f, 0f,       // B
        0f, 0f, 0f, 50f, -2000f   // A (Альфа-канал: множитель и отсечение прозрачности)
    ))
    val nativeColorFilter = AndroidColorMatrixColorFilter(gooeyMatrix)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFFE2F5E9), shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
    ) {
        // КОНТЕЙНЕР ДЛЯ ЭФФЕКТА КАПЛИ
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    // Применяем эффект размытия + контраста (работает на Android 12 и выше)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        val blurEffect = AndroidRenderEffect.createBlurEffect(
                            30f, 30f, AndroidShader.TileMode.CLAMP
                        )
                        val filterEffect = AndroidRenderEffect.createColorFilterEffect(
                            nativeColorFilter
                        )
                        // Объединяем фильтры: сначала размываем, затем накладываем матрицу контраста
                        val chainEffect = AndroidRenderEffect.createChainEffect(
                            filterEffect, blurEffect
                        )

                        // Приводим нативный RenderEffect к типу, который понимает Compose
                        renderEffect = chainEffect.asComposeRenderEffect()
                    }
                }
        ) {
            // Зеленый бокс, который будет превращаться в каплю при движении
            if (tabPositions.any { it > 0f }) {
                Box(
                    modifier = Modifier
                        .offset(x = with(density) { animatedX.toDp() })
                        .size(56.dp)
                        .align(Alignment.CenterStart)
                        .background(Color(0xFF00CC88), shape = RoundedCornerShape(18.dp))
                )
            }
        }

        // СЛОЙ С ИКОНКАМИ (Рендерится поверх капли, чтобы иконки не размывались)
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .onGloballyPositioned { coordinates ->
                            // Вычисляем точную позицию иконки для центрирования зеленого бокса
                            val parentOffsetX = coordinates.parentLayoutCoordinates
                                ?.localPositionOf(coordinates, Offset.Zero)?.x ?: 0f
                            val iconWidth = coordinates.size.width
                            val boxSize = with(density) { 56.dp.toPx() }

                            tabPositions[index] = parentOffsetX + (iconWidth - boxSize) / 2
                        }
                        .clickable { selectedIndex = index },
                    contentAlignment = Alignment.Center
                ) {
                    val isSelected = selectedIndex == index

                    // Вставьте сюда ваши кастомные иконки из ресурсов.
                    // Для теста используется стандартный системный компас.
                    Icon(
                        painter = painterResource(id = R.drawable.ic_menu_compass),
                        contentDescription = item,
                        tint = if (isSelected) Color.Black else Color(0xFF1C274C).copy(alpha = 0.6f),
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }
    }
}

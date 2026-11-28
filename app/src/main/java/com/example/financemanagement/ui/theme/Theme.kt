package com.example.financemanagement.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

object FinanceTheme {
    val backLightMode = Color(0xFFF1FFF3)
    val lightGreen = Color(0xFFDFF7E2)
    val mainGreen = Color(0xFF00D09E)
    val greenBar = Color(0xFF0E3E3E)
    val lettersAndIcons = Color(0xFF093030)
    val backDarkMode = Color(0xFF052224)
    val secondaryDarkMode = Color(0xFF031314)
    val lightBlueBtn = Color(0xFF6DB6FE)
    val blueBtn = Color(0xFF3299FF)
    val oceanBlueBtn = Color(0xFF0068FF)
}
private val LightColorScheme = lightColorScheme(
    primary = FinanceTheme.mainGreen,
    onPrimary = FinanceTheme.backDarkMode,
    primaryContainer = FinanceTheme.lightGreen,
    onPrimaryContainer = FinanceTheme.lettersAndIcons,
    background = Color.White,
    tertiary = FinanceTheme.greenBar,
    onTertiary = Color(0xFF363130),
    surface = FinanceTheme.oceanBlueBtn,
    outline = FinanceTheme.lettersAndIcons,
    outlineVariant = FinanceTheme.lettersAndIcons
)

private val DarkColorScheme = darkColorScheme(
    primary = FinanceTheme.lightGreen,
    onPrimary = FinanceTheme.lightGreen,
    primaryContainer = FinanceTheme.greenBar,
    onPrimaryContainer = FinanceTheme.greenBar,
    background = FinanceTheme.backDarkMode,
    tertiary = FinanceTheme.backLightMode,
    onTertiary = FinanceTheme.backLightMode,
    surface = FinanceTheme.oceanBlueBtn,
    outline = FinanceTheme.lightGreen,
    outlineVariant = FinanceTheme.backLightMode
)
val LocalFinanceColorScheme = staticCompositionLocalOf { LightColorScheme }
@Composable
fun FinanceManagementTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val financeColorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = financeColorScheme,
        typography = Typography,
        content = {
            CompositionLocalProvider(
                LocalFinanceColorScheme provides financeColorScheme
            ) {
                content()
            }
        }
    )
}
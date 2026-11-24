package com.example.financemanagement.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.financemanagement.R

val montserrat = FontFamily(
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_semi_bold, FontWeight.SemiBold),
)

val FinanceMTypography: Typography
    @Composable
    get() = Typography(
        titleMedium = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = montserrat,
            lineHeight = 22.sp
        ),
        titleSmall = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = montserrat
        ),
        bodyLarge = TextStyle(
            fontSize = 17.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = montserrat
        ),
        bodyMedium = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = montserrat
        ),
        bodySmall = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = montserrat
        ),
        labelLarge = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = montserrat
        ),
        labelMedium = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight.Light,
            fontFamily = montserrat,
            lineHeight = 15.sp
        ),
        labelSmall = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            fontFamily = montserrat,
            lineHeight = 15.sp
        )
    )
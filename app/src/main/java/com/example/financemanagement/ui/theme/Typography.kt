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
        titleSmall = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = montserrat,
            lineHeight = 22.sp
        ),
        bodyLarge = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = montserrat
        ),
        bodyMedium = TextStyle(
            fontSize = 17.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = montserrat
        ),
        bodySmall = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = montserrat
        ),
        labelLarge = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = montserrat
        ),
        labelMedium = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = montserrat
        ),
        labelSmall = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight.Light,
            fontFamily = montserrat,
            lineHeight = 15.sp
        )
    )
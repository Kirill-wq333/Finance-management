package com.example.financemanagement.ui.presentation.feature.shared.appLogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.financemanagement.R

@Composable
fun AppLogo(
    modifier: Modifier = Modifier,
    colorLogo: Color,
    colorText: Color
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_app_logo),
            contentDescription = null,
            tint = colorLogo
        )
        Text(
            text = "FinWise",
            color = colorText
        )
    }
}
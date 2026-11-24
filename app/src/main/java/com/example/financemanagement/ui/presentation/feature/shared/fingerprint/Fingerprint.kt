package com.example.financemanagement.ui.presentation.feature.shared.fingerprint

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financemanagement.R
import com.example.financemanagement.ui.theme.FinanceManagementTheme
import com.example.financemanagement.ui.theme.FinanceTheme

@Preview
@Composable
fun FingerPrint(
    modifier: Modifier = Modifier
) {
    val padding = 43.87.dp
    Box(
        modifier = modifier
            .background(
                color = FinanceTheme.mainGreen,
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_fingerprint),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .padding(
                    top = padding,
                    start = padding,
                    bottom = 39.dp,
                    end = padding
                )
                .size(107.25.dp, 112.12.dp)
        )
    }
}
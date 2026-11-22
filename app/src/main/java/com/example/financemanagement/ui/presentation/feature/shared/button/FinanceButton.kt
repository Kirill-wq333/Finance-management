package com.example.financemanagement.ui.presentation.feature.shared.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.financemanagement.ui.theme.FinanceMTypography
import com.example.financemanagement.ui.theme.FinanceTheme

@Composable
fun FinanceButton(
    modifier: Modifier = Modifier,
    text: String,
    colorButton: Color,
    onClick: () -> Unit,
    colorText: Color = FinanceTheme.lettersAndIcons,
    style: TextStyle = FinanceMTypography.titleSmall
) {
    Box(
        modifier = modifier
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
            .fillMaxWidth()
            .background(
                color = colorButton,
                shape = RoundedCornerShape(30.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = colorText,
            style = style,
            modifier = Modifier
                .padding(
                    top = 11.dp,
                    bottom = 12.dp
                )
        )
    }
}
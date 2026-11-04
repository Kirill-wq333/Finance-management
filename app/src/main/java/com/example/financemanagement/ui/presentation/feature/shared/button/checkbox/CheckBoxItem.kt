package com.example.financemanagement.ui.presentation.feature.shared.button.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financemanagement.R
import com.example.financemanagement.ui.theme.FinanceManagementTheme

@Preview
@Composable
private fun CheckBoxPrev() {

    var isSelected by remember { mutableStateOf(false) }
    FinanceManagementTheme() {
        Box(modifier = Modifier.background(Color.White)) {
            CheckBoxItem(
                isSelected = isSelected,
                onSelected = {isSelected = !isSelected}
            )
        }
    }
}

@Composable
fun CheckBoxItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onSelected: () -> Unit
) {

    Box(
        modifier = modifier
            .clickable(onClick = onSelected)
            .border(
                width = 1.64.dp,
                color = colorScheme.onSurface,
                shape = RoundedCornerShape(4.dp)
            )
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_check),
            contentDescription = null,
            tint = if (isSelected) colorScheme.onSurface else Color.Transparent,
            modifier = Modifier
                .padding(
                    top = 4.91.dp,
                    start = 4.91.dp,
                    bottom = 4.91.dp,
                    end = 3.27.dp
                )
        )
    }
}
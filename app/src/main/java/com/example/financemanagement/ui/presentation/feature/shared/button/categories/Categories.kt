package com.example.financemanagement.ui.presentation.feature.shared.button.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financemanagement.R
import com.example.financemanagement.ui.theme.FinanceManagementTheme

@Preview
@Composable
private fun PrevCategoriesItem() {
    FinanceManagementTheme() {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            CategoriesItem(
                icon = R.drawable.ic_food,
                tint = Color.Black,
                backColor = colorScheme.primary,
                padding = PaddingValues(
                    start = 16.dp,
                    top = 10.dp,
                    end = 16.dp,
                    bottom = 12.dp
                ),
                shape = RoundedCornerShape(22.dp),
                modifier = Modifier
            )
        }
    }
}


@Composable
fun CategoriesItem(
    icon: Int,
    tint: Color,
    backColor: Color,
    padding: PaddingValues,
    shape: Shape = RectangleShape,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = backColor,
                shape = shape
            )
    ) {
        Box(
            modifier = Modifier
                .padding(padding)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = null,
                tint = tint,
            )
        }
    }
}
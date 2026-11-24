package com.example.financemanagement.ui.presentation.feature.shared.floatLabel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.financemanagement.R
import com.example.financemanagement.ui.presentation.feature.shared.button.categories.CategoriesItem
import com.example.financemanagement.ui.theme.FinanceMTypography
import com.example.financemanagement.ui.theme.FinanceManagementTheme
import com.example.financemanagement.ui.theme.FinanceTheme

@Preview
@Composable
private fun PreviewSupportAssistant() {
    FinanceManagementTheme() {
        SupportAssistant(
            nameAssistant = "Support Assistant",
            lastMessage = "Hello! I'm here to assist you/ sdfhsdfhsfghsfhfs"
        )
    }
}

@Composable
fun SupportAssistant(
    modifier: Modifier = Modifier,
    nameAssistant: String,
    lastMessage: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(14.dp)
            )
            .padding(
                start = 10.dp,
                top = 13.dp,
                end = 6.dp,
                bottom = 7.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        AssistantItem(
            modifier = Modifier.weight(1f),
            nameAssistant = nameAssistant,
            lastMessage = lastMessage
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .background(
                    color = FinanceTheme.backLightMode,
                    shape = RoundedCornerShape(15.dp)
                )
                .padding(5.dp, 2.dp)
        ) {
            Text(
                text = "2 Min Ago",
                color = FinanceTheme.lettersAndIcons,
                style = FinanceMTypography.labelSmall,
            )
        }
    }
}

@Composable
fun AssistantItem(
    modifier: Modifier = Modifier,
    nameAssistant: String,
    lastMessage: String
) {
    Row(
        modifier = modifier
            .padding(bottom = 9.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        CategoriesItem(
            icon = R.drawable.ic_assistant,
            tint = FinanceTheme.greenBar,
            padding = PaddingValues(
                start = 7.dp,
                top = 7.dp,
                end = 5.74.dp,
                bottom = 7.77.dp
            ),
            shape = RoundedCornerShape(14.dp),
            sizeIcon = DpSize(32.dp, 30.dp)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = nameAssistant,
                color = MaterialTheme.colorScheme.tertiary,
                style = FinanceMTypography.titleSmall
            )
            Text(
                text = lastMessage,
                color = MaterialTheme.colorScheme.outlineVariant,
                style = FinanceMTypography.labelMedium,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        }
    }
}
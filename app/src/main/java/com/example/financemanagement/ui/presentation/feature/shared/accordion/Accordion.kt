package com.example.financemanagement.ui.presentation.feature.shared.accordion

import android.opengl.Visibility
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financemanagement.R
import com.example.financemanagement.ui.theme.FinanceMTypography
import com.example.financemanagement.ui.theme.FinanceManagementTheme

@Preview
@Composable
private fun PreviewAccordion() {
    FinanceManagementTheme() {
        Accordion(
            accordion = "How to use finWise?",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        )
    }
}

@Composable
fun Accordion(
    modifier: Modifier = Modifier,
    accordion: String,
    description: String,
    visibleB: Boolean = true
) {
    var visibleDescription by remember { mutableStateOf(false) }
    var visibleBox by remember { mutableStateOf(visibleB) }

    val colorBox = if (visibleBox) Color(0xFFDFF7E2) else Color.Transparent

    var padding = if (visibleBox) PaddingValues(
        start = 20.dp,
        top = 9.dp,
        end = 3.dp,
        bottom = 10.dp
    ) else PaddingValues(0.dp)

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(17.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ){ visibleDescription = !visibleDescription },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = accordion,
                color = MaterialTheme.colorScheme.outline,
                style = FinanceMTypography.bodySmall
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_bottom),
                contentDescription = null,
                modifier = Modifier
                    .rotate(if (visibleDescription) 180f else 0f)
            )
        }
        AnimatedVisibility(
            visible = visibleDescription,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = colorBox,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(padding)
            ) {
                Text(
                    text = description,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    style = FinanceMTypography.labelSmall
                )
            }
        }
    }
}

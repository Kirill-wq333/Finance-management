package com.example.financemanagement.ui.presentation.feature.shared.calendar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.financemanagement.R
import com.example.financemanagement.ui.presentation.feature.shared.picker.date.tools.PickerDaysCalculator
import com.example.financemanagement.ui.theme.FinanceMTypography
import com.example.financemanagement.ui.theme.FinanceTheme

@Composable
fun CalendarGrid(
    modifier: Modifier = Modifier,
    dateTimestamp: Long,
    onChooseDay: (Long) -> Unit
) {
    val daysList = remember(dateTimestamp) {
        val calculator = PickerDaysCalculator(dateTimestamp)
        calculator.getDays()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        MouthAndYears()
        Spacer(modifier = Modifier.height(24.dp))
        WeakDaysRow()
        Spacer(modifier = Modifier.height(8.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(daysList) { item ->
                DayItem(
                    number = ,
                    isActive = ,
                    isSelected = ,
                    onSelect = {}
                )
            }
        }
    }
}

@Composable
fun WeakDaysRow(modifier: Modifier = Modifier) {
    val ruWeekdaysList = remember {
        listOf("Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс")
    }
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(ruWeekdaysList.size) { i ->
            Text(
                text = ruWeekdaysList[i],
                style = MaterialTheme.typography.labelLarge,
                color = FinanceTheme.blueBtn
            )
        }
    }
}

@Composable
fun MouthAndYears(
    modifier: Modifier = Modifier,
    mouth: String,
    years: Int
) {
    var openMouth by remember { mutableStateOf(false) }
    var openYears by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MouthAndYearsItem(
            text = mouth,
            onClick = { openMouth = !openMouth }
        )
        MouthAndYearsItem(
            text = years.toString(),
            onClick ={ openYears = !openYears}
        )
    }
}

@Composable
fun MouthAndYearsItem(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(8.27.dp)
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.primary,
            style = FinanceMTypography.bodySmall
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_bottom),
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = null,
            modifier = Modifier
                .padding(top = 8.dp)
                .size(4.85.dp, 9.3.dp)
        )
    }
}

@Composable
fun DayItem(
    modifier: Modifier = Modifier,
    number: Int,
    isActive: Boolean,
    isSelected: Boolean,
    onSelect: () -> Unit
) {

    val numberColor = if (isActive && isSelected) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.onPrimary

    Box(
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { if (isActive) onSelect() }
            )
    ) {
        Text(
            text = number.toString(),
            color = numberColor,
            style = FinanceMTypography.labelLarge,
            modifier = Modifier
                .padding(
                    start = 5.86.dp,
                    top = 8.33.dp,
                    end = 5.36.dp,
                    bottom = 7.27.dp
                )
        )
    }
}
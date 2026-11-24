package com.example.financemanagement.ui.presentation.feature.shared.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.financemanagement.R
import com.example.financemanagement.ui.theme.FinanceMTypography
import com.example.financemanagement.ui.theme.FinanceTheme

@Composable
fun Action(
    modifier: Modifier = Modifier,
    onFirstClickBtn: () -> Unit,
    onSecondClickBtn: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(11.dp)
    ) {
        FinanceButton(
            text = stringResource(R.string.btn_yes_end_session),
            colorButton = FinanceTheme.mainGreen,
            style = FinanceMTypography.bodySmall,
            onClick = onFirstClickBtn
        )
        FinanceButton(
            text = stringResource(R.string.btn_cancel),
            colorButton = FinanceTheme.lightGreen,
            style = FinanceMTypography.bodySmall,
            onClick = onSecondClickBtn
        )
    }
}
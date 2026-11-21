package com.example.financemanagement.ui.presentation.feature.shared.floatLabel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financemanagement.R
import com.example.financemanagement.ui.presentation.feature.shared.button.FinanceButton
import com.example.financemanagement.ui.theme.FinanceMTypography
import com.example.financemanagement.ui.theme.FinanceManagementTheme
import com.example.financemanagement.ui.theme.FinanceTheme

@Preview
@Composable
private fun PreviewEndSession() {
    FinanceManagementTheme() {
        EndSession(
            onLogout = {},
            onCancel = {}
        )
    }
}

@Composable
fun EndSession(
    modifier: Modifier = Modifier,
    onLogout: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(
                top = 42.dp,
                end = 52.dp,
                bottom = 54.dp,
                start = 52.dp
            ),
        verticalArrangement = Arrangement.spacedBy(46.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(11.dp)
        ) {
            Text(
                text = stringResource(R.string.end_session),
                color = MaterialTheme.colorScheme.tertiary,
                style = FinanceMTypography.bodyMedium
            )
            Text(
                text = stringResource(R.string.end_session_subtitle),
                color = MaterialTheme.colorScheme.onTertiary,
                style = FinanceMTypography.bodySmall
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(11.dp)
        ) {
            FinanceButton(
                text = stringResource(R.string.btn_yes_end_session),
                colorButton = FinanceTheme.mainGreen,
                style = FinanceMTypography.labelLarge,
                onClick = onLogout
            )
            FinanceButton(
                text = stringResource(R.string.btn_cancel),
                colorButton = FinanceTheme.lightGreen,
                style = FinanceMTypography.labelLarge,
                onClick = onCancel
            )
        }
    }
}
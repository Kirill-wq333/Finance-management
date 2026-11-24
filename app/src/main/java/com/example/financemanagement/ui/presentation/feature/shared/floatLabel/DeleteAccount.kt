package com.example.financemanagement.ui.presentation.feature.shared.floatLabel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financemanagement.R
import com.example.financemanagement.ui.presentation.feature.shared.button.Action
import com.example.financemanagement.ui.theme.FinanceMTypography
import com.example.financemanagement.ui.theme.FinanceManagementTheme

@Preview
@Composable
private fun PreviewDeleteAccount() {
    FinanceManagementTheme() {
        DeleteAccount(
            onDeleteAccount = {},
            onCancel = {}
        )
    }
}

@Composable
fun DeleteAccount(
    modifier: Modifier = Modifier,
    onDeleteAccount: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(
                start = 34.dp,
                top = 45.dp,
                end = 30.dp,
                bottom = 45.dp
            ),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.delete_account),
                color = MaterialTheme.colorScheme.tertiary,
                style = FinanceMTypography.titleSmall
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(R.string.delete_account_subtitle1),
                color = MaterialTheme.colorScheme.onTertiary,
                style = FinanceMTypography.bodySmall,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(19.dp))
            Text(
                text = stringResource(R.string.delete_account_subtitle2),
                color = MaterialTheme.colorScheme.onTertiary,
                style = FinanceMTypography.bodyLarge,
                textAlign = TextAlign.Center
            )
        }
        Action(
            onFirstClickBtn = onDeleteAccount,
            onSecondClickBtn = onCancel
        )
    }
}
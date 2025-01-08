package br.com.rubensrodrigues.presentation.ui.atomic.organisms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.rubensrodrigues.presentation.R
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme
import br.com.rubensrodrigues.presentation.utils.extensions.Padding

@Composable
fun ErrorOrganism(
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.error_message),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.error,
            )
            Padding()
            Button(
                onClick = onRetryClick
            ) {
                Text(
                    stringResource(R.string.error_button_text).uppercase(),
                    color = MaterialTheme.colorScheme.secondary,
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        ErrorOrganism({})
    }
}
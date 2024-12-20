package br.com.rubensrodrigues.presentation.ui.atomic.atoms

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.rubensrodrigues.presentation.R
import br.com.rubensrodrigues.presentation.ui.theme.Dimen
import br.com.rubensrodrigues.presentation.ui.theme.Typography
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme
import br.com.rubensrodrigues.presentation.utils.extensions.Padding

@Composable
fun DateAtom(
    day: String,
    month: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = day,
            style = Typography.titleSmall.copy(MaterialTheme.colorScheme.onBackground),
        )
        Padding(Dimen.extraSmallMargin)
        MonthAtom(month = month)
    }
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        DateAtom(
            day = "21",
            month = "Jul"
        )
    }
}
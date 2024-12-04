package br.com.rubensrodrigues.f1companion.atomic.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.rubensrodrigues.f1companion.atomic.atoms.MonthAtom
import br.com.rubensrodrigues.f1companion.ui.theme.Dimen
import br.com.rubensrodrigues.f1companion.ui.theme.F1CompanionTheme
import br.com.rubensrodrigues.f1companion.ui.theme.Typography
import br.com.rubensrodrigues.f1companion.utils.extensions.Padding

@Composable
fun DateMolecule(
    days: String,
    month: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            days,
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
        DateMolecule(
            days = "21 - 23",
            month = "Jul"
        )
    }
}
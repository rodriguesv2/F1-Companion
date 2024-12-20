package br.com.rubensrodrigues.presentation.ui.atomic.atoms

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme

@Composable
fun LoadingAtom(modifier: Modifier = Modifier) {
    CircularProgressIndicator(modifier)
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        LoadingAtom()
    }
}
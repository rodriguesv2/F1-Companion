package br.com.rubensrodrigues.presentation.ui.atomic.organisms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rubensrodrigues.presentation.ui.atomic.atoms.LoadingAtom
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme

@Composable
fun LoadingOrganism(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LoadingAtom(
            modifier = Modifier
                .size(60.dp)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        LoadingOrganism()
    }
}
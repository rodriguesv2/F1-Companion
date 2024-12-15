package br.com.rubensrodrigues.presentation.ui.atomic.atoms

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.rubensrodrigues.presentation.ui.theme.F1CompanionTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleAtom(
    title: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}

@Preview
@Composable
private fun Preview() {
    F1CompanionTheme {
        TitleAtom("Racing")
    }
}
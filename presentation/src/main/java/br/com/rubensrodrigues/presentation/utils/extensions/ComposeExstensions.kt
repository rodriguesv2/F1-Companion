package br.com.rubensrodrigues.presentation.utils.extensions

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import br.com.rubensrodrigues.presentation.ui.theme.Dimen

@Composable
fun RowScope.Padding(size: Dp = Dimen.defaultMargin) {
    Spacer(modifier = Modifier.width(size))
}

@Composable
fun ColumnScope.Padding(size: Dp = Dimen.defaultMargin) {
    Spacer(modifier = Modifier.height(size))
}
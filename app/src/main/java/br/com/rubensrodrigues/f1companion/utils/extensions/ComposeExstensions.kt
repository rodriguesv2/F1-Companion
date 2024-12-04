package br.com.rubensrodrigues.f1companion.utils.extensions

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import br.com.rubensrodrigues.f1companion.ui.theme.Dimen

@Composable
fun RowScope.Padding(size: Dp = Dimen.defaultMargin) {
    Spacer(modifier = Modifier.padding(size))
}

@Composable
fun ColumnScope.Padding(size: Dp = Dimen.defaultMargin) {
    Spacer(modifier = Modifier.padding(size))
}
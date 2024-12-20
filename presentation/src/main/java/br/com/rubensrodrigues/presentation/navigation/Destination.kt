package br.com.rubensrodrigues.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import br.com.rubensrodrigues.presentation.R
import kotlinx.serialization.Serializable

sealed interface Destination {
    val icon: Int
    val title: Int

    @Serializable
    data object Racings : Destination {
        @DrawableRes override val icon = R.drawable.ic_flag
        @StringRes override val title = R.string.racing_title
    }

    @Serializable
    data object Standings : Destination {
        @DrawableRes override val icon = R.drawable.ic_standings
        @StringRes override val title = R.string.standings_title

    }

    companion object {
        val items = listOf(Racings, Standings)
    }
}
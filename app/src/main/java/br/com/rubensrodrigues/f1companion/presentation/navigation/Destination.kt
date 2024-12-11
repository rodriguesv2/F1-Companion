package br.com.rubensrodrigues.f1companion.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import br.com.rubensrodrigues.f1companion.R
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
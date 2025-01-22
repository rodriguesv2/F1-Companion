package br.com.rubensrodrigues.presentation.di

import br.com.rubensrodrigues.presentation.ui.pages.grandprix.GrandPrixViewModel
import br.com.rubensrodrigues.presentation.ui.pages.standings.StandingsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { GrandPrixViewModel(get()) }
    viewModel { StandingsViewModel(get()) }
}
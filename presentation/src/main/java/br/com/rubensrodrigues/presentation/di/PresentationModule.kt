package br.com.rubensrodrigues.presentation.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import br.com.rubensrodrigues.presentation.ui.pages.grandprix.GrandPrixViewModel

val presentationModule = module {
    viewModelOf(::GrandPrixViewModel)
}
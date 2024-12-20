package br.com.rubensrodrigues.domain.di

import br.com.rubensrodrigues.domain.repositories.Formula1Repository
import org.koin.dsl.module
import br.com.rubensrodrigues.domain.usecases.GetGrandPrixUseCase

val domainModule = module {
    single { GetGrandPrixUseCase(get<Formula1Repository>()::getGrandPrix) }
}
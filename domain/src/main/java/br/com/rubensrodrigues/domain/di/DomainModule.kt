package br.com.rubensrodrigues.domain.di

import br.com.rubensrodrigues.domain.repositories.Formula1Repository
import org.koin.dsl.module
import br.com.rubensrodrigues.domain.usecases.GetGrandPrixUseCase
import br.com.rubensrodrigues.domain.usecases.GetStandingsUseCase

val domainModule = module {
    single { GetGrandPrixUseCase(get<Formula1Repository>()::getGrandPrix) }
    single { GetStandingsUseCase(get<Formula1Repository>()::getStandings) }
}
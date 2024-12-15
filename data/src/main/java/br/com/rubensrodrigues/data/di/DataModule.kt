package br.com.rubensrodrigues.data.di

import br.com.rubensrodrigues.data.repositories.local.Formula1RepositoryMock
import br.com.rubensrodrigues.domain.repositories.Formula1Repository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    singleOf(::Formula1RepositoryMock) { bind<Formula1Repository>() }
}
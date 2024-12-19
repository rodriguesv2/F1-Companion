package br.com.rubensrodrigues.data.di

import br.com.rubensrodrigues.data.datasources.Formula1Datasource
import br.com.rubensrodrigues.data.datasources.Formula1DatasourceImpl
import br.com.rubensrodrigues.data.repositories.remote.Formula1RepositoryImpl
import br.com.rubensrodrigues.domain.repositories.Formula1Repository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    includes(networkingModule)
    singleOf(::Formula1DatasourceImpl) { bind<Formula1Datasource>() }
//    singleOf(::Formula1RepositoryMock) { bind<Formula1Repository>() }
    singleOf(::Formula1RepositoryImpl) { bind<Formula1Repository>() }
}
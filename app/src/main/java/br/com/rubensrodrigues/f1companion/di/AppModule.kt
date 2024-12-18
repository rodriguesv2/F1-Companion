package br.com.rubensrodrigues.f1companion.di

import br.com.rubensrodrigues.data.di.API_KEY_VALUE
import br.com.rubensrodrigues.f1companion.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single(named(API_KEY_VALUE)) {
        BuildConfig.API_KEY
    }
}
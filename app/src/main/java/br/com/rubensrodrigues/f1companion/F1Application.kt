package br.com.rubensrodrigues.f1companion

import android.app.Application
import br.com.rubensrodrigues.data.di.dataModule
import br.com.rubensrodrigues.domain.di.domainModule
import br.com.rubensrodrigues.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class F1Application : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@F1Application)
            modules(
                dataModule,
                domainModule,
                presentationModule,
            )
        }
    }
}
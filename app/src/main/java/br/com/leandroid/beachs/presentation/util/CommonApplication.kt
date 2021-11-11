package br.com.leandroid.beachs.presentation.util

import android.app.Application
import br.com.leandroid.data.dataModule
import br.com.leandroid.domain.di.domainModule
import br.com.leandroid.beachs.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CommonApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@CommonApplication)
            modules(listOf(
                dataModule,domainModule, presentationModule
            ))
        }
    }
}
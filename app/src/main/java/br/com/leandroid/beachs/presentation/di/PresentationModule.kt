package br.com.leandroid.beachs.presentation.di

import br.com.leandroid.beachs.presentation.beach.BeachViewModel
import org.koin.dsl.module

val presentationModule = module {

    single {
        BeachViewModel(get())
    }

}

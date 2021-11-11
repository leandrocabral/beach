package br.com.leandroid.domain.di

import br.com.leandroid.domain.usecase.BeachUseCase
import org.koin.dsl.module

val domainModule = module {

    single {
        BeachUseCase(get())
    }
}
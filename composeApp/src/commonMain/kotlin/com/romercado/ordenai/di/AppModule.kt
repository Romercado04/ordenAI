package com.romercado.ordenai.di

import com.romercado.ordenai.data.repository.FakePlannerRepository
import com.romercado.ordenai.domain.repository.PlannerRepository
import com.romercado.ordenai.presentation.PlannerViewModel
import org.koin.dsl.module

val appModule = module {

    single<PlannerRepository> {
        FakePlannerRepository()
    }

    factory {
        PlannerViewModel(get())
    }
}
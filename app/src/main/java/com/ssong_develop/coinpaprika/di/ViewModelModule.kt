package com.ssong_develop.coinpaprika.di

import com.ssong_develop.coinpaprika.presentation.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule : Module = module {

    viewModel { MainViewModel(get()) }
}
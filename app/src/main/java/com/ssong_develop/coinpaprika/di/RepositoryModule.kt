package com.ssong_develop.coinpaprika.di

import com.ssong_develop.coinpaprika.domain.repository.CoinRepository
import com.ssong_develop.coinpaprika.domain.repository.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single<Repository> { CoinRepository(source = get()) }
}

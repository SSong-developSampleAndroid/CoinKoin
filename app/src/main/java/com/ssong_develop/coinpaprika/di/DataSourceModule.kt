package com.ssong_develop.coinpaprika.di

import com.ssong_develop.coinpaprika.data.source.CoinDataSource
import com.ssong_develop.coinpaprika.data.source.DataSource
import org.koin.dsl.module

val dataSourceModule = module {
    factory<DataSource> { CoinDataSource(service = get()) }
}

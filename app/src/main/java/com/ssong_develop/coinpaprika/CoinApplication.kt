package com.ssong_develop.coinpaprika

import android.app.Application
import com.ssong_develop.coinpaprika.di.dataSourceModule
import com.ssong_develop.coinpaprika.di.repositoryModule
import com.ssong_develop.coinpaprika.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CoinApplication)
            modules(listOf(retrofitModule, dataSourceModule, repositoryModule))
        }
    }
}
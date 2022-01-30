package com.ssong_develop.coinpaprika.di

import com.ssong_develop.coinpaprika.data.service.CoinService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    single { provideRetrofit(get()) }
    factory { provideOkHttpClient(get()) }
    factory { provideLoggingInterceptor() }
    factory { provideCoinService(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.coinpaprika.com/v1/")
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()
}

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val logger = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }
    return logger
}

fun provideCoinService(retrofit: Retrofit): CoinService = retrofit.create(CoinService::class.java)


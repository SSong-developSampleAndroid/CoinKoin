package com.ssong_develop.coinpaprika.data.service

import com.ssong_develop.coinpaprika.data.entity.CoinDTO
import io.reactivex.Observable
import retrofit2.http.GET

interface CoinService {
    @GET("coins")
    fun fetchCoins(): Observable<List<CoinDTO>>
}
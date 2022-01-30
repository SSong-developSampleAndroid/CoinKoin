package com.ssong_develop.coinpaprika.data.source

import com.ssong_develop.coinpaprika.data.entity.CoinDTO
import io.reactivex.Observable

interface DataSource {
    fun fetch(): Observable<List<CoinDTO>>
}
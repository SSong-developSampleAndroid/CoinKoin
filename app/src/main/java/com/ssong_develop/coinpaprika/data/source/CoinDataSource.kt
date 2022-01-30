package com.ssong_develop.coinpaprika.data.source

import com.ssong_develop.coinpaprika.data.entity.CoinDTO
import com.ssong_develop.coinpaprika.data.service.CoinService
import io.reactivex.Observable

class CoinDataSource(
    private val service: CoinService
) : DataSource {
    override fun fetch(): Observable<List<CoinDTO>> = service.fetchCoins()
}
package com.ssong_develop.coinpaprika.mapper

import com.ssong_develop.coinpaprika.data.entity.CoinDTO
import com.ssong_develop.coinpaprika.domain.entity.Coin

interface Mapper {
    fun toDomain(
        coinDTO: CoinDTO
    ): Coin
}
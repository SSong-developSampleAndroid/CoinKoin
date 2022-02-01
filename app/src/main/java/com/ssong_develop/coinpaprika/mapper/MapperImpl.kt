package com.ssong_develop.coinpaprika.mapper

import com.ssong_develop.coinpaprika.data.entity.CoinDTO
import com.ssong_develop.coinpaprika.domain.entity.Coin

class MapperImpl : Mapper {
    override fun toDomain(coinDTO: CoinDTO): Coin {
        return Coin(
            coinId = coinDTO.coinId,
            coinName = coinDTO.coinName,
            coinSymbol = coinDTO.coinSymbol,
            coinRank = coinDTO.coinRank,
            isNewCoin = coinDTO.isNewCoin,
            isActiveCoin = coinDTO.isActiveCoin,
            coinType = coinDTO.coinType
        )
    }
}
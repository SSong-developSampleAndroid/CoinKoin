package com.ssong_develop.coinpaprika.domain.entity

data class Coin(
    val coinId: String,
    val coinName: String,
    val coinSymbol: String,
    val coinRank: Int,
    val isNewCoin: Boolean,
    val isActiveCoin: Boolean,
    val coinType: String
)

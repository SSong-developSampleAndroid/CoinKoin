package com.ssong_develop.coinpaprika.data.entity

import com.google.gson.annotations.SerializedName
import com.ssong_develop.coinpaprika.domain.entity.Coin

data class CoinDTO(
    @SerializedName("id")
    val coinId: String,
    @SerializedName("name")
    val coinName: String,
    @SerializedName("symbol")
    val coinSymbol: String,
    @SerializedName("rank")
    val coinRank: Int,
    @SerializedName("is_new")
    val isNewCoin: Boolean,
    @SerializedName("is_active")
    val isActiveCoin: Boolean,
    @SerializedName("type")
    val coinType: String
)

fun CoinDTO.mapToCoin(): Coin {
    return Coin(
        coinId = coinId,
        coinName = coinName,
        coinSymbol = coinSymbol,
        coinRank = coinRank,
        isNewCoin = isNewCoin,
        isActiveCoin = isActiveCoin,
        coinType = coinType
    )
}

fun List<CoinDTO>.mapToCoinList(): List<Coin> {
    return map {
        it.mapToCoin()
    }
}
package com.ssong_develop.coinpaprika.domain.repository

import com.ssong_develop.coinpaprika.domain.entity.Coin
import io.reactivex.disposables.Disposable

interface Repository {
    fun load(
        doOnSubscribe: () -> Unit,
        doOnError: (String) -> Unit,
        doOnComplete: () -> Unit,
        onSubscribe: (List<Coin>) -> Unit,
        onTerminate: () -> Unit
    ): Disposable
}
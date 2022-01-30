package com.ssong_develop.coinpaprika.domain.repository

import io.reactivex.disposables.Disposable

interface Repository {
    fun load(): Disposable
}
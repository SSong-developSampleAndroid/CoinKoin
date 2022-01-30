package com.ssong_develop.coinpaprika.domain.repository

import android.util.Log
import com.ssong_develop.coinpaprika.data.entity.mapToCoinList
import com.ssong_develop.coinpaprika.data.source.DataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CoinRepository(
    private val source: DataSource
) : Repository {
    override fun load(): Disposable {
        return source.fetch()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                Log.d("SSong-develop", "doOnSubscribe")
            }
            .doOnTerminate {
                Log.d("SSong-develop", "doOnTerminate")
            }
            .subscribe {
                Log.d("SSong-develop", "${it.mapToCoinList()}")
            }
    }
}
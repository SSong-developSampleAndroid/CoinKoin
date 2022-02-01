package com.ssong_develop.coinpaprika.domain.repository


import com.ssong_develop.coinpaprika.data.source.DataSource
import com.ssong_develop.coinpaprika.domain.entity.Coin
import com.ssong_develop.coinpaprika.mapper.MapperImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CoinRepository(
    private val source: DataSource
) : Repository {
    override fun load(
        doOnSubscribe: () -> Unit,
        doOnError:(String) -> Unit,
        doOnComplete: () -> Unit,
        onSubscribe: (List<Coin>) -> Unit,
        onTerminate: () -> Unit
    ): Disposable {
        return source.fetch()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                doOnSubscribe()
            }
            .doOnError{
                doOnError(it.toString())
            }
            .doOnComplete {
                doOnComplete()
            }
            .doOnTerminate {
                onTerminate()
            }
            .subscribe { resource ->
                onSubscribe(resource.map { MapperImpl().toDomain(it) })
            }
    }
}
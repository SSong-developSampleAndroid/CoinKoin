package com.ssong_develop.coinpaprika.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ssong_develop.coinpaprika.domain.entity.Coin
import com.ssong_develop.coinpaprika.domain.repository.Repository
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    private val repository: Repository
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val loading = MutableLiveData<Boolean>(false)

    val errorToastLiveData = MutableLiveData<String>()

    private val _coinsLiveData = MutableLiveData<List<Coin>>()
    val coinsLiveData: LiveData<List<Coin>>
        get() = _coinsLiveData

    init {
        repository.load(
            doOnSubscribe = {
                loading.value = true
            },
            doOnError = {
                errorToastLiveData.postValue(it)
            },
            doOnComplete = {
                loading.value = false
            },
            onSubscribe = {
                _coinsLiveData.value = it
            },
            onTerminate = {
                loading.value = false
            }
        ).also {
            compositeDisposable.add(it)
        }
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
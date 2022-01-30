package com.ssong_develop.coinpaprika.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ssong_develop.coinpaprika.R
import com.ssong_develop.coinpaprika.databinding.ActivityMainBinding
import com.ssong_develop.coinpaprika.domain.repository.Repository
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this,R.layout.activity_main)
    }

    private val compositeDisposable = CompositeDisposable()

    private val repository: Repository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        compositeDisposable.add(repository.load())
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
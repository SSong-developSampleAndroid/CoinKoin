package com.ssong_develop.coinpaprika.presentation.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ssong_develop.coinpaprika.R
import com.ssong_develop.coinpaprika.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this,R.layout.activity_main)
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding){
            lifecycleOwner = this@MainActivity
            vm = viewModel
        }

        viewModel.coinsLiveData.observe(this){
            binding.test.text = it.toString()
        }

        viewModel.errorToastLiveData.observe(this){
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        }
    }
}
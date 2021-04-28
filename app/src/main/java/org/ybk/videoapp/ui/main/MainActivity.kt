package org.ybk.videoapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.ybk.videoapp.R
import org.ybk.videoapp.data.BaseRepository
import org.ybk.videoapp.databinding.ActMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActMainBinding
    private val repository: BaseRepository by inject()
    private val mainViewModel: MainViewModel by viewModel {
        parametersOf(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActMainBinding>(
            this, R.layout.act_main).apply {
            lifecycleOwner = this@MainActivity
            activity = this@MainActivity
            viewmodel = mainViewModel
        }
    }
}
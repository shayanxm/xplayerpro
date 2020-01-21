package com.example.xplayer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.xplayer.R
import com.example.xplayer.databinding.ActivityBaseHolderBinding
import com.example.xplayer.model.Song
import com.example.xplayer.viewmodel.BaseHolderViewModel

class BaseHolderActivity : AppCompatActivity() {
private lateinit var viewModel:BaseHolderViewModel
    lateinit var binding: ActivityBaseHolderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
binding=DataBindingUtil.setContentView(this,R.layout.activity_base_holder)
        viewModel=ViewModelProviders.of(this).get(BaseHolderViewModel::class.java)
        binding.viewModel=viewModel

    }
}

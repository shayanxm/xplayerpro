package com.example.xplayer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.xplayer.R
import com.example.xplayer.adapters.ViewPagerAdapter
import com.example.xplayer.databinding.ActivityBaseHolderBinding
import com.example.xplayer.model.Song
import com.example.xplayer.ui.viewpagerfragements.AlbumsFragment
import com.example.xplayer.ui.viewpagerfragements.ArtistsFragment
import com.example.xplayer.ui.viewpagerfragements.FavSongsFragment
import com.example.xplayer.ui.viewpagerfragements.SongsFragment
import com.example.xplayer.viewmodel.BaseHolderViewModel
import kotlinx.android.synthetic.main.activity_base_holder.*

class BaseHolderActivity : AppCompatActivity() {
private lateinit var viewModel:BaseHolderViewModel
    lateinit var binding: ActivityBaseHolderBinding
    lateinit var viewPagerAdapter:ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
binding=DataBindingUtil.setContentView(this,R.layout.activity_base_holder)
        viewModel=ViewModelProviders.of(this).get(BaseHolderViewModel::class.java)
        binding.viewModel=viewModel
        viewPagerAdapter=ViewPagerAdapter(getSupportFragmentManager())


        viewPagerAdapter.addFrag(SongsFragment.newInstance(),"1")
        viewPagerAdapter.addFrag(ArtistsFragment.newInstance(),"1")
        viewPagerAdapter.addFrag(FavSongsFragment.newInstance(),"1")
        viewPager.adapter=viewPagerAdapter;

    }
}

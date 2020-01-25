package com.example.xplayer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import com.example.xplayer.R
import com.example.xplayer.adapters.ViewPagerAdapter
import com.example.xplayer.controller.SongLab
import com.example.xplayer.databinding.ActivityBaseHolderBinding
import com.example.xplayer.model.Song
import com.example.xplayer.ui.basefrags.HomeFragment
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
        overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out)
binding=DataBindingUtil.setContentView(this,R.layout.activity_base_holder)
        viewModel=ViewModelProviders.of(this).get(BaseHolderViewModel::class.java)
        binding.viewModel=viewModel
        SongLab.mContext=this
        SongLab.setAllSongList(applicationContext)
Log.e("xx","${SongLab.mAllSong.size}")
        supportFragmentManager.inTransaction {

            add(R.id.fragment_continer_cl, HomeFragment.newintance(""))
        }



    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }


}

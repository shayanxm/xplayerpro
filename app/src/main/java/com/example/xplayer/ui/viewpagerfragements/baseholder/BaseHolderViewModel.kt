package com.example.xplayer.ui.viewpagerfragements.baseholder

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.example.xplayer.adapters.ViewPagerAdapter
import com.example.xplayer.model.Song
import com.example.xplayer.util.setViewPager
import fakhteh.fanavaran.mydagger.di.component.moduel.SongLab
import javax.inject.Inject

class BaseHolderViewModel:ViewModel() {

    var mSongTitleTxt = ObservableField<String>("No name")
    var mArtistNameTxt= ObservableField<String>("NO name")
    var mSongArtWorkAdd= ObservableField<String>("null")
    @Inject
    lateinit var mSongLab: List<Song>
    init {

       // Log.e("x","${mSongLab.size}")
    }
    fun infoClClicked(){

        Log.e("x","${mSongLab.size}")
        Log.e("x","${mSongLab.size} , ${mSongLab.get(2).mSongName}")
    }
}
package com.example.xplayer.viewmodel

import android.app.Application
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.example.xplayer.adapters.ViewPagerAdapter
import com.example.xplayer.util.setViewPager

class BaseHolderViewModel(application: Application):AndroidViewModel(application) {

    var mSongTitleTxt = ObservableField<String>("No name")
    var mArtistNameTxt= ObservableField<String>("NO name")
    var mSongArtWorkAdd= ObservableField<String>("null")

    fun infoClClicked(){
        Log.e("test","ingo")
    }
}
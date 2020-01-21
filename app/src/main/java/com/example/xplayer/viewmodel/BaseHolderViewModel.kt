package com.example.xplayer.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class BaseHolderViewModel:ViewModel() {
    var mSongTitleTxt =ObservableField<String>("No name")
    var mArtistNameTxt=ObservableField<String>("NO name")
    var mSongArtWorkAdd=ObservableField<String>("null")

    init {

    }

     fun infoClClicked(){
        Log.e("test","ingo")
    }
}
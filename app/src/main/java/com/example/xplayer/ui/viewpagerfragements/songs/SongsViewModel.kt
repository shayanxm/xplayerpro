package com.example.xplayer.ui.viewpagerfragements.songs

import androidx.lifecycle.MutableLiveData

class SongsViewModel {
    private val songTitle = MutableLiveData<String>()
    fun getPostTitle(): MutableLiveData<String> {
        return songTitle
    }

}
package com.example.xplayer.ui.viewpagerfragements.songs

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.xplayer.adapters.MusicsAdapter
import com.example.xplayer.model.Song
import java.lang.Exception
import javax.inject.Inject

class SongsViewModel : ViewModel() {
    @Inject
    lateinit var mSongLab: List<Song>
    val musicListAdapter: MusicsAdapter = MusicsAdapter()
    private val songTitle = MutableLiveData<String>()
    private val songName = MutableLiveData<String>()
    private val artisName = MutableLiveData<String>()
    fun getPostTitle(): MutableLiveData<String> {
        return songTitle
    }
    init {

           // musicListAdapter.updatePostList(mSongLab)

    }
    fun getSongName(): MutableLiveData<String> {
        return songName
    }
    fun getArtistName(): MutableLiveData<String> {
        return artisName
    }

    fun bind(weatherData: Song) {
        songTitle.value = weatherData.mSongName
        artisName.value = weatherData.mAristName
    }
    fun test(){  Log.e("xzzz","${mSongLab.size}")
        Log.e("xzzz","${mSongLab.size} , ${mSongLab.get(2).mSongName}")}

}
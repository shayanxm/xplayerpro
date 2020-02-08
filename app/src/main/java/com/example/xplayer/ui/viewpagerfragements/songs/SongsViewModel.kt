package com.example.xplayer.ui.viewpagerfragements.songs

import androidx.lifecycle.MutableLiveData
import com.example.xplayer.adapters.MusicsAdapter
import com.example.xplayer.model.Song
import javax.inject.Inject

class SongsViewModel {
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
        musicListAdapter.updatePostList(mSongLab);
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
}
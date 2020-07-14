package com.example.xplayer

import android.app.Application
import com.example.xplayer.data.Singleton

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        Singleton.setAllSongList(applicationContext)
Singleton.setListOfAlbum(applicationContext)
    }
}
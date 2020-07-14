package com.example.xplayer.handlers

import android.content.ContentUris
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import android.net.Uri
import com.example.xplayer.ui.viewpagerfragements.songs.SongsFragment

class SongListHandler {

    companion object {





         fun getsongArtWork(path: String): Bitmap? {
            val mmr = MediaMetadataRetriever()
            mmr.setDataSource(path)
            val data = mmr.embeddedPicture
            return if (data != null) BitmapFactory.decodeByteArray(data, 0, data.size) else null
        }
}
}
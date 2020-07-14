package com.example.xplayer.util

import android.content.ContentUris
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import android.net.Uri
import com.example.xplayer.ui.viewpagerfragements.songs.SongsFragment

class SongListHandler {

    companion object {



    fun getAlbumart(context: Context, album_id: Long?): Bitmap? {
        var albumArtBitMap: Bitmap? = null
        val options = BitmapFactory.Options()
        try {
            val sArtworkUri = Uri
                .parse("content://media/external/audio/albumart")
            val uri = ContentUris.withAppendedId(sArtworkUri, album_id!!)
            var pfd = context.contentResolver
                .openFileDescriptor(uri, "r")
            if (pfd != null) {
                var fd = pfd.fileDescriptor
                albumArtBitMap = BitmapFactory.decodeFileDescriptor(
                    fd, null,
                    options
                )
                pfd = null
                fd = null
            }
        } catch (ee: Error) {
        } catch (e: Exception) {
        }
        return albumArtBitMap
    }

         fun getsongArtWork(path: String): Bitmap? {
            val mmr = MediaMetadataRetriever()
            mmr.setDataSource(path)
            val data = mmr.embeddedPicture
            return if (data != null) BitmapFactory.decodeByteArray(data, 0, data.size) else null
        }
}
}
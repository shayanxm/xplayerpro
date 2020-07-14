package com.example.xplayer.handlers

import android.content.ContentUris
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri

class AlubumListHandler {
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
    }
}
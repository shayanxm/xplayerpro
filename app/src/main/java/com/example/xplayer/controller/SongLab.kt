package com.example.xplayer.controller

import android.content.Context
import android.provider.BaseColumns
import android.provider.MediaStore
import android.util.Log
import com.example.xplayer.model.Song
import java.util.ArrayList

object SongLab {
    lateinit var mAllSong:List<Song>
    lateinit var mContext:Context
init {
Log.e("xx","initniinglab")

}
    fun setAllSongList(context:Context){
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0"
        val sortOrder = MediaStore.Audio.Media.TITLE + " ASC"
        val cr = mContext.getContentResolver()
        val cur = cr.query(uri, null, selection, null, sortOrder)
        var count = 0
        val names = ArrayList<String>()
        val namesz = ArrayList<String>()
        val albumId = ArrayList<String>()
        val allSongs = ArrayList<Song>()
        var thisArtist = ""
        var thisTitle = ""
        var album = ""
        val albumTestId: String
        var i = 0
        if (cur != null) {
            count = cur!!.getCount()

            if (count > 0) {
                while (cur!!.moveToNext()) {

                    val titleColumn = cur!!.getColumnIndex(MediaStore.MediaColumns.TITLE)
                    val idColumn = cur!!.getColumnIndex(BaseColumns._ID)
                    val albumIdH = cur!!.getColumnIndex(MediaStore.Audio.Albums._ID)
                    //   int albumIdH = cur.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ID);
                    //   int albumIdH = cur.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ARTIST_ID);
                    val artistColumn = cur!!.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST)
                    val artistId = cur!!.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST_ID)
                    val artistColumns = cur!!.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM)
                    val column_index = cur!!.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)
                    val data = cur!!.getString(cur!!.getColumnIndex(MediaStore.Audio.Media.DATA))
                    thisTitle = cur!!.getString(titleColumn)
                    val albumIdSeted = cur!!.getString(albumIdH)
                    thisArtist = cur!!.getString(artistColumn)
                    album = cur!!.getString(artistColumns)
                    val artistIdSeted = cur!!.getString(artistId)
                    namesz.add(album)
                    //     albumId.add(test);
                    // Add code to get more column here
                    names.add(data)
                    // Save to your list here


                    /////////////
                    val song = Song(data)
                    song.mAlbumName=album
                    song.mAlbumId=albumIdSeted

                    song.mAristId=artistIdSeted
                    song.mSongName=thisTitle
                    song.mAristName=thisArtist
                    song.mAlbumArtWorkPath=albumIdSeted
                    song.mSongArtWorkPath=data
                    song.mNumbPointer=i
                    //                    song.setmAlbumArtWorkPath(getAlbumart(mContext, Long.valueOf(albumIdSeted)));
                    //                    song.setmSongArtWorkPath(getsongArtWork(data));
                    //
                    //

                    allSongs.add(song)
                    i++
                }

            }
        }
        mAllSong = allSongs

    }

}
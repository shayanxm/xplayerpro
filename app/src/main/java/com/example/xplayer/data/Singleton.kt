package com.example.xplayer.data

import android.content.Context
import android.database.Cursor
import android.provider.BaseColumns
import android.provider.MediaStore
import android.util.Log
import com.example.xplayer.model.Album
import com.example.xplayer.model.Song
import java.lang.Exception

object Singleton {
    lateinit var mAllSong:List<Song>
lateinit var mAllAlbums: List<Album>
init {

}

    /**
     *
     * this method provides all songs of phone
     *
     * @param context the type of a member in this group.
     * @property context the name of this group.
     * @constructor Creates an empty group.
     */
    fun setAllSongList( context: Context):List<Song>{
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0"
        val sortOrder = MediaStore.Audio.Media.TITLE + " ASC"
        val cr = context.getContentResolver()
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
                    Log.e("pathis",song.mSongArtWorkPath)
                    Log.e("pathis2",song.mAlbumArtWorkPath)
                }

            }
        }
        Log.e("xx","${allSongs.size}")
        mAllSong = allSongs
        return allSongs
    }

    fun setListOfAlbum(context: Context) {
        val where: String? = null
        val uri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI
        val _id = MediaStore.Audio.Albums._ID
        val album_name = MediaStore.Audio.Albums.ALBUM
        val artist = MediaStore.Audio.Albums.ARTIST
        val albumart = MediaStore.Audio.Albums.ALBUM_ART
        val tracks = MediaStore.Audio.Albums.NUMBER_OF_SONGS
        var i = 0
        val columns =
            arrayOf(_id, album_name, artist, albumart, tracks)
        val cursor: Cursor? = context.getContentResolver().query(
            uri, columns, where,
            null, null
        )
        val list = java.util.ArrayList<Album>()
        // add playlsit to list
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                   // val albumData = Album(cursor.getString(cursor.getColumnIndex(_id)))

                    val currentAlbum=Album()
                    val albumIdCursor =cursor.getColumnIndex(_id)
                    val albumNameCursor =cursor.getColumnIndex(album_name)
                    val artistCursor =cursor.getColumnIndex(artist)
                    val albumartCursor =cursor.getColumnIndex(albumart)


                    currentAlbum.mAlubmId=cursor!!.getString(albumIdCursor)
                    currentAlbum.mAlbumName=cursor!!.getString(albumNameCursor)
                    currentAlbum.mAlbumArtistName=cursor!!.getString(artistCursor)
                    try {
                        currentAlbum.mAlumArtWorkPath=cursor!!.getString(albumartCursor)
                    }catch (e:Exception){
                        Log.e("alubm","no album art work found")
                    }











                    list.add(currentAlbum)
                } while (cursor.moveToNext())
            }
        }
        if (cursor != null) {
            cursor.close()
        }
        mAllAlbums = list
        Log.e("sixin","${mAllAlbums.size}")
    }
}
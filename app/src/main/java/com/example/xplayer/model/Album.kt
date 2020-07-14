package com.example.xplayer.model

import java.util.*

class Album {
    var mAlubmId:String="";
    var mAlbumName:String=""
    var mAlbumArtistName:String=""
     var mAlumArtWorkPath:String=""
    lateinit var mSongList:List<Song>
    var mAlnumIdGenerated:UUID= UUID.randomUUID()
    var mNumbPointerAlbum:Int = 0
}
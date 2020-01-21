package com.example.xplayer.model

import java.util.*

class Album {
    var mAlubmId:String="";
    var mAlbumName:String=""
    var mAlbumArt:String=""
     var mAlumArtWorkPath:String=""
    lateinit var mSongList:List<Song>
    var mAlnumIdGenerated:UUID= UUID.randomUUID()
    var mNumbPointerAlbum:Int = 0
}
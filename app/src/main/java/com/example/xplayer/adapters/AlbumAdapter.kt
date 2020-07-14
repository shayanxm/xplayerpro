package com.example.xplayer.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.xplayer.BR
import com.example.xplayer.R
import com.example.xplayer.databinding.AlbumListRowBinding
import com.example.xplayer.handlers.AlubumListHandler
import com.example.xplayer.handlers.SongListHandler
import com.example.xplayer.model.Album

class AlbumAdapter(var context: Context) : RecyclerView.Adapter<AlbumAdapter.ViewHodler>() {
    private var songList: List<Album> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodler {
        val binding: AlbumListRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.album_list_row, parent, false
        )
        return AlbumAdapter.ViewHodler(binding)
    }

    override fun getItemCount(): Int = songList.size

    override fun onBindViewHolder(holder: ViewHodler, position: Int) {
        Log.e("wdsfxcx","sdfx")
  holder.bind(songList.get(position))
    //    holder.binidg(songList.get(position))
 bindView(holder, position)
    }

    fun bindView(holder: ViewHodler, position: Int) {

        holder.binding.songImageIv.setImageBitmap(AlubumListHandler.getAlbumart(context,songList.get(position).mAlubmId.toLong()))
    }

    fun setAdapter(list: List<Album>) {
        this.songList = list
        Log.e("wdsfxcx","${list.size}")
        notifyDataSetChanged()
    }

    class ViewHodler(val binding: AlbumListRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binidg(album: Album){
//            binding.songNameTv.setText(album.mAlbumName)
          //  binding.songImageIv.setImageBitmap(AlubumListHandler.getAlbumart())

        }
        fun bind(data: Any) {

            binding.setVariable(BR.vmx, data)
            binding.executePendingBindings()
            Log.e("wdsfxcx","sdfx22")

        }
    }


}
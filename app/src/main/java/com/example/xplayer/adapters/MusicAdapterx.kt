package com.example.xplayer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.xplayer.BR
import com.example.xplayer.R
import com.example.xplayer.databinding.SongListRowBinding
import com.example.xplayer.model.Song

class MusicAdapterx(var context: Context):RecyclerView.Adapter<MusicAdapterx.ViewHodler>() {
private  var songList:List<Song> = emptyList()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodler {
   val binding:SongListRowBinding=DataBindingUtil.inflate(LayoutInflater.from(context),
       R.layout.song_list_row,parent,false)
        return MusicAdapterx.ViewHodler(binding)
    }

    override fun getItemCount(): Int=songList.size

    override fun onBindViewHolder(holder: ViewHodler, position: Int) {
        holder.bind(songList.get(position))
    }
    fun setAdapter(list:List<Song>){
        this.songList=list
        notifyDataSetChanged()
    }
    class ViewHodler(val binding:SongListRowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind (data:Any){
            binding.setVariable(BR.vm,data)
            binding.executePendingBindings()
        }
    }

}
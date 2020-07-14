package com.example.xplayer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.xplayer.R
import com.example.xplayer.databinding.SongListRowBinding
import com.example.xplayer.model.Song
import com.example.xplayer.ui.viewpagerfragements.songs.SongsViewModel

class MusicsAdapter : RecyclerView.Adapter<MusicsAdapter.MyViewHolder>() {
    private lateinit var mainList:List<Song>

    public var onItemClickx: ((pos: Int) -> Unit)? = null
    public var onEditClick: ((pos: Int) -> Unit)? = null

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicsAdapter.MyViewHolder {

        val binding: SongListRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.song_list_row, parent, false)
        //  val binding: ItemPostBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_post, parent, false)
        return MyViewHolder(binding)
    }



    override fun onBindViewHolder(holder: MusicsAdapter.MyViewHolder, position: Int) {

        holder.bind(mainList[position])
//        val weatherData = mainList[position]
//        holder.bindView(weatherData, position)

//        holder.itemView.setOnClickListener {
//            Log.e("delete", "detelte it ${weatherData.id}")
//
//            val v: View = holder.itemView
//
//            onItemClick?.invoke(position, v)
//        }
    }

    override fun getItemCount(): Int {
        return if(::mainList.isInitialized) mainList.size else 0
    }
    fun updatePostList(postList:List<Song>){
        this.mainList = postList
        notifyDataSetChanged()
    }
    inner  class MyViewHolder(private val binding:SongListRowBinding) : RecyclerView.ViewHolder(binding.root) {

        //2
        // private var view: View = v
        // private var photo: Photo? = null
        private var name: Song? = null
        private val viewModel = SongsViewModel()

        //3

        //4
//        override fun onClick(v: View) {
//            Log.d("RecyclerView", "CLICK!")
//        }
//
//
//        fun bindView(name: WeatherData, position: Int) {
//
//viewModel.bind(name)
//            this.name = name
//            binding.
//         //   view.row_name.text = name.title
//        view.row_delete_item.setOnClickListener {
//           // Log.e("delete", "detelte it ${weatherData.id}")
//
//          //  val v: View = holder.itemView
//
//            onItemClickx?.invoke(position)
//        }
//            view.row_edit_item.setOnClickListener {
//                // Log.e("delete", "detelte it ${weatherData.id}")
//
//                //  val v: View = holder.itemView
//
//                onEditClick?.invoke(position)
//            }
//            when (name.prio) {
//                Prioritys.HIGH.prioNum -> view.setBackgroundColor(Color.RED)
//                Prioritys.MEDIUM.prioNum -> view.setBackgroundColor(Color.YELLOW)
//                Prioritys.LOW.prioNum -> view.setBackgroundColor(Color.GREEN)
//                Prioritys.UNDIFINED.prioNum -> view.setBackgroundColor(Color.GRAY)
//
//            }
//        }
//
//    }




        //   override fun getItemCount() = mainList.size
//    fun update(modelList:ArrayList<WeatherData>,adapter: ToDoAdapter) {
//     mainList = modelList
//     // adapter!!.notifyDataSetChanged()
// }
        fun bind(post:Song){
            viewModel.bind(post)

          //  binding.vm = viewModel
        }
        // lateinit var mainList :List<String>
        lateinit var context: Context



    }}
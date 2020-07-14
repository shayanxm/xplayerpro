package com.example.xplayer.ui.viewpagerfragements.albums


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.xplayer.R
import com.example.xplayer.adapters.AlbumAdapter
import com.example.xplayer.adapters.MusicAdapterx
import com.example.xplayer.data.Singleton
import com.example.xplayer.databinding.FragmentAlbumsBinding
import com.example.xplayer.ui.viewpagerfragements.songs.SongsFragment
import com.example.xplayer.ui.viewpagerfragements.songs.SongsViewModel
import kotlinx.android.synthetic.main.fragment_albums.*
import kotlinx.android.synthetic.main.fragment_albums.view.*
import kotlinx.android.synthetic.main.fragment_songs.view.*

/**
 * A simple [Fragment] subclass.
 */
class AlbumsFragment : Fragment() {
lateinit var binding:FragmentAlbumsBinding
    private lateinit var viewModel: AlbumsViewModel
    var fragmentView: View? = null
    private var albumAdapter: AlbumAdapter? = null
    companion object {


        fun newInstance(): AlbumsFragment {
            return AlbumsFragment()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_albums, container, false)
        viewModel = ViewModelProviders.of(this).get(AlbumsViewModel::class.java)
        binding.viewModel = viewModel

        Log.e("songlabxx", "xxxxxxxxxxx")

        fragmentView = binding?.root


        initAdapter()
        setAdapter()
        setAlbumList()
//        val applicationContextModule = ApplicationContextModule(requireContext().applicationContext)
//        DaggerDataBaseComponent.builder().applicationContextModule(applicationContextModule).build().injectTaskVm(viewModel)
        return binding.root
    }

    fun setAlbumList() {
        albumAdapter?.setAdapter(Singleton.mAllAlbums)
        Log.e("sdfsdx", "${Singleton.mAllAlbums.size}")

    }

    private fun setAdapter() {
        Log.e("adaptindx", "ada")
        fragmentView?.album_list_rv?.apply {
            layoutManager = GridLayoutManager(activity,2)
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            adapter = albumAdapter
        }

    }

    private fun initAdapter() {
        Log.e("adaptindx", "ada")
        albumAdapter = AlbumAdapter(this@AlbumsFragment.requireActivity())
    }


}

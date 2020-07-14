package com.example.xplayer.ui.viewpagerfragements.songs


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.xplayer.R
import com.example.xplayer.adapters.MusicAdapterx
import com.example.xplayer.data.Singleton
import com.example.xplayer.databinding.ActivityBaseHolderBinding
import com.example.xplayer.databinding.FragmentSongsBinding
import com.example.xplayer.model.Song
import fakhteh.fanavaran.mydagger.di.component.commp.DaggerSongLabComponent
import fakhteh.fanavaran.mydagger.di.component.moduel.AppModuel
import kotlinx.android.synthetic.main.fragment_songs.view.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SongsFragment : Fragment() {

    lateinit var binding: FragmentSongsBinding
    private lateinit var viewModel: SongsViewModel

    var fragmentView: View? = null
    private var songAdapterx: MusicAdapterx? = null

    companion object {


        fun newInstance(): SongsFragment {
            return SongsFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("songlabxx", "xxxxxxxxxxx")
        Log.e("sizing", "${Singleton.mAllSong.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_songs, container, false)
        viewModel = ViewModelProviders.of(this).get(SongsViewModel::class.java)
        binding.viewModel = viewModel

        Log.e("songlabxx", "xxxxxxxxxxx")

        fragmentView = binding?.root
        initAdapter()
        setAdapter()
        fetchRetroInfo()
//        val applicationContextModule = ApplicationContextModule(requireContext().applicationContext)
//        DaggerDataBaseComponent.builder().applicationContextModule(applicationContextModule).build().injectTaskVm(viewModel)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val applicationContextModule = AppModuel(requireContext().applicationContext)
        DaggerSongLabComponent.builder().appModuel(applicationContextModule).build()
            .injectViewModelx(viewModel)
    }


    fun fetchRetroInfo() {
        songAdapterx?.setAdapter(Singleton.mAllSong)
//        retroViewModel.postInfoLiveData?.observe(this,object: Observer<List<PostInfo>> {
//            override fun onChanged(t: List<PostInfo>?) {
//                t?.apply {
//                    listAdapter?.setAdapterList(t)
//                }
//
//
//            }
//        })
    }

    private fun setAdapter() {
        Log.e("adaptindx", "ada")
        fragmentView?.sont_list_rv?.apply {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            adapter = songAdapterx
        }

    }

    private fun initAdapter() {
        Log.e("adaptindx", "ada")
        songAdapterx = MusicAdapterx(this@SongsFragment.requireActivity())
    }

}

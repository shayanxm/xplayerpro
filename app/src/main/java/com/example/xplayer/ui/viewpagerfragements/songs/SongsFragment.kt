package com.example.xplayer.ui.viewpagerfragements.songs


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.example.xplayer.R
import com.example.xplayer.data.Singleton
import com.example.xplayer.databinding.ActivityBaseHolderBinding
import com.example.xplayer.databinding.FragmentSongsBinding
import com.example.xplayer.model.Song
import fakhteh.fanavaran.mydagger.di.component.commp.DaggerSongLabComponent
import fakhteh.fanavaran.mydagger.di.component.moduel.AppModuel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SongsFragment : Fragment() {
    @Inject
    lateinit var mSongLab:List<Song>

    @Inject
    lateinit var AppContext: Context
    lateinit var binding:FragmentSongsBinding
    private lateinit var viewModel: SongsViewModel
    companion object {

        fun newInstance(): SongsFragment {
            return SongsFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("songlabxx","xxxxxxxxxxx")
Log.e("sizing","${Singleton.mAllSong.size}")
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_songs, container,false)
        viewModel = ViewModelProviders.of(this).get(SongsViewModel::class.java)
        binding.viewModel=viewModel

        Log.e("songlabxx","xxxxxxxxxxx")


//        val applicationContextModule = ApplicationContextModule(requireContext().applicationContext)
//        DaggerDataBaseComponent.builder().applicationContextModule(applicationContextModule).build().injectTaskVm(viewModel)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val applicationContextModule = AppModuel(requireContext().applicationContext)
        DaggerSongLabComponent.builder().appModuel(applicationContextModule).build().injectViewModelx(viewModel)
    }


}

package com.example.xplayer.ui.viewpagerfragements.songs


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.example.xplayer.R

/**
 * A simple [Fragment] subclass.
 */
class SongsFragment : Fragment() {
  //  lateinit var binding:SongsFragmentData
    private lateinit var viewModel: SongsViewModel
    companion object {

        fun newInstance(): SongsFragment {
            return SongsFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

      //  binding =
        //    DataBindingUtil.inflate(inflater,R.layout.fragment_songs, container,false)


       // viewModel = ViewModelProviders.of(this).get(SongsViewModel::class.java)
       // binding.viewModel=viewModel
       // val applicationContextModule = ApplicationContextModule(requireContext().applicationContext)
      //  DaggerDataBaseComponent.builder().applicationContextModule(applicationContextModule).build().injectTaskVm(viewModel)
       // return binding.root
return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}

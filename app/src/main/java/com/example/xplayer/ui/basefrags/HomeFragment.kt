package com.example.xplayer.ui.basefrags


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders

import com.example.xplayer.R
import com.example.xplayer.adapters.ViewPagerAdapter
import com.example.xplayer.databinding.ActivityBaseHolderBinding
import com.example.xplayer.ui.viewpagerfragements.ArtistsFragment
import com.example.xplayer.ui.viewpagerfragements.FavSongsFragment
import com.example.xplayer.ui.viewpagerfragements.SongsFragment
import com.example.xplayer.viewmodel.BaseHolderViewModel
import com.example.xplayer.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    companion object {
        fun newintance(tag: String): HomeFragment {
            val taskDoalogFragment = HomeFragment()

            return taskDoalogFragment

        }
    }
    private lateinit var viewModel: HomeViewModel
    lateinit var binding: HomeFragmentBinding
    lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_home, container,false)


        viewModel = ViewModelProviders.of(this).get(HomeViewModel()::class.java)
      //  binding.viewModel=viewModel

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPagerUp()
    }
    private fun setViewPagerUp() {
        viewPagerAdapter = ViewPagerAdapter(activity!!.getSupportFragmentManager())
        viewPagerAdapter.addFrag(SongsFragment.newInstance(), "SONGS")
        viewPagerAdapter.addFrag(ArtistsFragment.newInstance(), "ARTIST")
        viewPagerAdapter.addFrag(FavSongsFragment.newInstance(), "TRACKS")
        viewPagerAdapter.addFrag(FavSongsFragment.newInstance(), "FAVORITES")
        viewPagerAdapter.addFrag(FavSongsFragment.newInstance(), "FAVORITES")
        viewPagerAdapter.addFrag(FavSongsFragment.newInstance(), "FAVORITES")
        viewPager.adapter = viewPagerAdapter
        tabs.setupWithViewPager(viewPager)
    }

}

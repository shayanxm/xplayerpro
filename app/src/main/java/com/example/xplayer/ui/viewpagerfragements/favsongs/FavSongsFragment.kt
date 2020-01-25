package com.example.xplayer.ui.viewpagerfragements.favsongs


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.xplayer.R
import com.example.xplayer.ui.viewpagerfragements.artists.ArtistsFragment

/**
 * A simple [Fragment] subclass.
 */
class FavSongsFragment : Fragment() {
    companion object {

        fun newInstance(): ArtistsFragment {
            return ArtistsFragment()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav_songs, container, false)
    }


}

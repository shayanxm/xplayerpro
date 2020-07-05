package com.example.xplayer.ui.viewpagerfragements.baseholder

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import com.example.xplayer.R
import com.example.xplayer.adapters.ViewPagerAdapter

import com.example.xplayer.databinding.ActivityBaseHolderBinding
import com.example.xplayer.model.Song

import com.example.xplayer.ui.basefrags.home.HomeFragment
import fakhteh.fanavaran.mydagger.di.component.commp.DaggerSongLabComponent
import fakhteh.fanavaran.mydagger.di.component.moduel.AppModuel
import javax.inject.Inject

class BaseHolderActivity : AppCompatActivity() {
private lateinit var viewModel: BaseHolderViewModel
    lateinit var binding: ActivityBaseHolderBinding
    lateinit var viewPagerAdapter:ViewPagerAdapter

    @Inject
    lateinit var mSongLab:List<Song>

    @Inject
    lateinit var AppContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out)
binding=DataBindingUtil.setContentView(this,R.layout.activity_base_holder)
        viewModel=ViewModelProviders.of(this).get(BaseHolderViewModel::class.java)
        binding.viewModel=viewModel

        val applicationContextModule = AppModuel(applicationContext)
        val taskViewModel=
            BaseHolderViewModel()

        DaggerSongLabComponent.builder().appModuel(applicationContextModule).build().injectViewModel(viewModel)


       // val applicationContextModule = AppModule(applicationContext)
       //DaggerSing.builder().applicationContextModule(applicationContextModule).build().injectViewModel(this)
//        SongLab.mContext=this
//        SongLab.setAllSongList(applicationContext)
//Log.e("xx","${SongLab.mAllSong.size}")

        supportFragmentManager.inTransaction {

            add(R.id.fragment_continer_cl, HomeFragment.newintance(""))
        }



    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }


}

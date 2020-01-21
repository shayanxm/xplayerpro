package com.example.xplayer.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT ){

     val  mFragmentList:ArrayList<Fragment>? = null
     val  mFragmentTitleList:ArrayList<String>? = null
    override fun getItem(position: Int): Fragment {

            return mFragmentList!!.get(position)


 //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        if (mFragmentList != null) {
            return mFragmentList.size
        }
        else return 0
    }
    public fun addFrag(fragment: Fragment,title:String){
        if (mFragmentList != null) {
            mFragmentList.add(fragment)
        }
        if (mFragmentTitleList != null) {
            mFragmentTitleList.add(title)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (mFragmentTitleList != null) {
            return mFragmentTitleList.get(position)
        }
        else return ""
    }
}
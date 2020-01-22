package com.example.xplayer.util

import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.databinding.BindingAdapter
import com.example.xplayer.adapters.ViewPagerAdapter


@BindingAdapter(value = ["android:pagerAdapter"], requireAll = false)
fun setViewPager(viewPager: ViewPager, adapter: ViewPagerAdapter) {

    viewPager.adapter = adapter
}
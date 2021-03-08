package com.emedinaa.kotlinapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.emedinaa.kotlinapp.fragment.ShoppingFragment
import com.emedinaa.kotlinapp.fragment.VideoFragment
import com.emedinaa.kotlinapp.fragment.WebFragment

class TabsPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager,
BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    private val titles = listOf("WEB","SHOPPING", "VIDEO")
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> WebFragment()
            1 -> ShoppingFragment()
            else -> VideoFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}
package com.example.youtubeapi.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.youtubeapi.ui.Main

class ViewPagerAdapter( fragmentManager : FragmentManager): FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment {
        return Main(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0->"All"
            1->"Mixes"
            2->"Music"
            3->"Graphic"
            else->"Last seen"
        }
    }
}
package com.example.youtubeapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.youtubeapi.Adapters.ViewPagerAdapter
import com.example.youtubeapi.R
import com.example.youtubeapi.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout


class Home : Fragment() {

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        val  view = inflater.inflate(R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        view.findViewById<ViewPager>(R.id.vp).adapter = ViewPagerAdapter(childFragmentManager)
        view.findViewById<TabLayout>(R.id.round_tabs).setupWithViewPager(view.findViewById<ViewPager>(R.id.vp))
        return view
    }


}
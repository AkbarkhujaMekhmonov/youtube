package com.example.youtubeapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.youtubeapi.Adapters.ViewPagerAdapter
import com.example.youtubeapi.R
import com.example.youtubeapi.databinding.FragmentHomeBinding
import com.example.youtubeapi.databinding.HomeFragment2Binding


class Home2 : Fragment() {
lateinit var binding : HomeFragment2Binding

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subscribtion, container, false)
    }


}
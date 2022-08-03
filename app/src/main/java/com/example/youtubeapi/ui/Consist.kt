package com.example.youtubeapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.youtubeapi.LibraryFragment
import com.example.youtubeapi.R
import com.example.youtubeapi.databinding.FragmentConsistBinding


class Consist : Fragment() {
    lateinit var binding : FragmentConsistBinding

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        binding = FragmentConsistBinding.inflate(layoutInflater)
        binding.clickHome.setOnClickListener {
            clear()
            binding.mainButton.setImageResource(R.drawable.home_bold)
            activity?.supportFragmentManager!!.beginTransaction()
                .replace(com.example.youtubeapi.R.id.fragment_container, Home()).commit()

        }
        binding.clickShorts.setOnClickListener {
            findNavController().navigate(R.id.shorts2)
        }
        binding.clickSubs.setOnClickListener {
            clear()
            binding.subscribeButton.setImageResource(com.example.youtubeapi.R.drawable.subscribe_org_bold)

            activity?.supportFragmentManager!!.beginTransaction()
                .replace(com.example.youtubeapi.R.id.fragment_container, SubscribtionFragment()).commit()
        }
        binding.clickLibrary.setOnClickListener {
            clear()
            binding.libraryButton.setImageResource(R.drawable.subscribe_bold)
            activity?.supportFragmentManager!!.beginTransaction()
                .replace(com.example.youtubeapi.R.id.fragment_container, LibraryFragment()).commit()
        }

        return binding.root
    }

    fun clear() {
        binding.mainButton.setImageResource(R.drawable.ic_vector__7_)
        binding.shortButton.setImageResource(R.drawable.ic_group_3)
        binding.subscribeButton.setImageResource(R.drawable.ic_group__1_)
        binding.libraryButton.setImageResource(R.drawable.ic_group)
    }

}
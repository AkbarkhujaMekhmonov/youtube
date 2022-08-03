package com.example.youtubeapi.ui

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.Adapters.YoutubeAdapter
import com.example.youtubeapi.R
import com.example.youtubeapi.databinding.FragmentMainBinding
import com.example.youtubeapi.models.Item
import com.example.youtubeapi.utils.Status
import com.example.youtubeapi.viewModels.YouTubeViewModel

class Main(var position : Int) : Fragment() {
    lateinit var binding : FragmentMainBinding
    lateinit var youTubeViewModel : YouTubeViewModel
    lateinit var youtubeAdapter : YoutubeAdapter
    lateinit var list : ArrayList<Item>

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        list = ArrayList()
        try {
            youtubeAdapter = YoutubeAdapter(list)
            binding.rv.adapter = youtubeAdapter
            youTubeViewModel = ViewModelProvider(this)[YouTubeViewModel::class.java]

            youTubeViewModel.getYouTubeData(binding.root.context).observe(requireParentFragment().viewLifecycleOwner) {
               when (it.status) {
                    Status.ERROR -> {
                        binding.progresbar.visibility = View.GONE
                        Toast.makeText(binding.root.context, it.message, Toast.LENGTH_SHORT).show()
                        Toast.makeText(binding.root.context, "error", Toast.LENGTH_SHORT).show()

                    }
                    Status.SUCCESS -> {
                        binding.progresbar.visibility = View.GONE
                        list.addAll(it.data!!.items)
                        youtubeAdapter.notifyDataSetChanged()
                        Log.d(ContentValues.TAG, "onCreate: ${it.data}")
                        Toast.makeText(binding.root.context, "success", Toast.LENGTH_SHORT).show()


                    }
                    Status.LOADING -> {
                        Toast.makeText(binding.root.context, "load", Toast.LENGTH_SHORT).show()

                        binding.progresbar.visibility = View.VISIBLE
                    }
                }
            }
        } catch (e : Exception) {
        }
        return binding.root
    }


}
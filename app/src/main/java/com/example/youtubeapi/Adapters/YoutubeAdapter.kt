package com.example.youtubeapi.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.databinding.ItemBinding
import com.example.youtubeapi.models.Item
import com.squareup.picasso.Picasso


class YoutubeAdapter(var list : List<Item>) : RecyclerView.Adapter<YoutubeAdapter.MyVH>() {
    inner class MyVH(var itemBinding : ItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(item : Item) {
            Picasso.get().load(item.snippet.thumbnails.high.url).into(itemBinding.image)
            itemBinding.text.text=item.snippet.title
            itemBinding.chanelName.text="${item.snippet.channelTitle}, 2.1 mln views, 2 month ago"
        }
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : MyVH =
        MyVH(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder : MyVH, position : Int) = holder.onBind(list[position])
    override fun getItemCount() : Int = list.size

}
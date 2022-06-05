package com.example.newsly

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter: RecyclerView.Adapter<NewsItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}

class NewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val TitleView : TextView = itemView.findViewById(R.id.title)

}
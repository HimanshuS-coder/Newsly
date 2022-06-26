package com.example.newsly

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// NewsListAdapter takes DATA in its constructor
// Here For example i am taking a list of strings just to understand how recycler view works
class NewsListAdapter( private val listener : NewsItemClicked): RecyclerView.Adapter<NewsItemViewHolder>() {

    private val items : ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        // This function will be called everytime a view of data is created
        // This function returns the xml that we created for news item view holder
        // But we can't directly return the xml as it is, firstafall it needs to be converted in VIEW
        // and to do so we need LAYOUT INFLATER CLASS
        // LAYOUT INFLATED CLASS IS USED TO CONVERT AN XML DOCUMENT TO VIEW
        Log.d("REACHED","FINALLY REACHED")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder = NewsItemViewHolder(view)

        view.setOnClickListener{
            val data = items[viewHolder.adapterPosition]
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        // This is the function which binds the data (fetching from constructor) with the view (simply the view that we have created in xml file)
        val currentData = items[position]
        holder.titleView.text = currentData.title
        holder.author.text = currentData.author
        Glide.with(holder.itemView.context).load(currentData.urlToImage).into(holder.urlImage);
    }

    override fun getItemCount(): Int {
        // This method is called once to fetch the item count like how many items are going to be there and this function needs INTEGER in return
        return items.count() // This will return the current count number of the data that we're receiving in the above CONSTRUCTOR
    }

    fun updateListData(updatedData : ArrayList<News>){
        items.clear() // This Clears out the List
        items.addAll(updatedData) // This line adds a collection of list at once.

        notifyDataSetChanged() // This line is used to refresh the adapter so basically what it does is, it calls all the above methods again.
    }

}

class NewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView : TextView = itemView.findViewById(R.id.title)
    val urlImage : ImageView = itemView.findViewById(R.id.urlImage)
    val author : TextView = itemView.findViewById(R.id.author)
}

interface NewsItemClicked{
    fun onItemClicked(item : News)
}
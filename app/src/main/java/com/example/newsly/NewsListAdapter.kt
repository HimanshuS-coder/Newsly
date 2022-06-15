package com.example.newsly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
// NewsListAdapter takes DATA in its constructor
// Here For example i am taking a list of strings just to understand how recycler view works
class NewsListAdapter(private val items : ArrayList<String>): RecyclerView.Adapter<NewsItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        // This function will be called everytime a view of data is created
        // This function returns the xml that we created for news item view holder
        // But we can't directly return the xml as it is, firstafall it needs to be converted in VIEW
        // and to do so we need LAYOUT INFLATER CLASS
        // LAYOUT INFLATED CLASS IS USED TO CONVERT AN XML DOCUMENT TO VIEW
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewsItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        // This is the function which binds the data (fetching from constructor) with the view (simply the view that we have created in xml file)
        val currentData = items[position]
        holder.titleView.text = currentData
    }

    override fun getItemCount(): Int {
        // This method is called once to fetch the item count like how many items are going to be there and this function needs INTEGER in return
        return items.count() // This will return the current count number of the data that we're receiving in the above CONSTRUCTOR
    }

}

class NewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView : TextView = itemView.findViewById(R.id.title)
}
package com.example.newsly

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONArray
import org.json.JSONObject


class MainActivity : AppCompatActivity() , NewsItemClicked {

    private lateinit var mAdapter : NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        itemData()
        mAdapter = NewsListAdapter(this)
        recyclerView.adapter = mAdapter

    }

    private fun itemData(){

        val url = "https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"

        // Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url,null,
            {
                try {
                    val newsArrayList: JSONArray = it.getJSONArray("articles")
                    val list = ArrayList<News>()
                    for(i in 0 until newsArrayList.length()){
                        val newsJsonObject : JSONObject = newsArrayList.getJSONObject(i)
                        val news = News(newsJsonObject.getString("title"),
                            newsJsonObject.getString("author"),newsJsonObject.getString("url"),newsJsonObject.getString("urlToImage"))

                        list.add(news)
                    }

                    mAdapter.updateListData(list)

                }catch (e: Exception){
                    e.printStackTrace()
                }
            },
            { Log.d("error",it.localizedMessage) })
        // Add the request to the RequestQueue.
        // queue.add(jsonObjectRequest)     --> Nor this
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }


    override fun onItemClicked(item: News) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(item.url))
    }
}
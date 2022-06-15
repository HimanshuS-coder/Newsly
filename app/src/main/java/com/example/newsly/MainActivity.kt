package com.example.newsly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val dataList : ArrayList<String> = itemData()
        val adapteR : NewsListAdapter = NewsListAdapter(dataList)
        recyclerView.adapter = adapteR


    }

    private fun itemData() : ArrayList<String>{
        val list = ArrayList<String>()
        for(i in 0 until 100){
            list.add("Item no $i")
        }
        return list
    }
}
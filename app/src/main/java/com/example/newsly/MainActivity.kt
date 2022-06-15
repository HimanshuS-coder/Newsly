package com.example.newsly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() , NewsItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val dataList : ArrayList<String> = itemData()
        val adapteR : NewsListAdapter = NewsListAdapter(dataList,this)
        recyclerView.adapter = adapteR

    }

    private fun itemData() : ArrayList<String>{
        val list = ArrayList<String>()
        for(i in 100 until 200){
            list.add("Item no $i")
        }
        return list
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this,"Clicked item is $item",Toast.LENGTH_SHORT).show()
    }
}
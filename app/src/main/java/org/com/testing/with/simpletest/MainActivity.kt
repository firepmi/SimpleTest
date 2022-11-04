package org.com.testing.with.simpletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.map
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.mRecyclerView);
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        var array = arrayListOf<Article>()
        MainViewModel().data.observe(this) { item ->
            item.forEach {
                array.add(it)
            }
            Log.d("~~~~", array.size.toString())
            val adapter = RVCustomAdapter(array)
            recyclerView.adapter = adapter
        }
    }
}
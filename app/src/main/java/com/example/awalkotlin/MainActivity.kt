package com.example.awalkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var item: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initial recylerview
        val list = findViewById<RecyclerView>(R.id.club_list)
        initData()
        // set layout manager
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, item) {
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_LONG)
            toast.show()
        }
        // settext in kotlin

    }

    private fun initData() {
        // set data
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.clum_image)

        item.clear()
        for (i in name.indices) {
            // menampung data ke dalam suatu list dengan menggunakan object Item
            item.add(Item(name[i], image.getResourceId(i, 0)))
        }
        image.recycle()
    }
}

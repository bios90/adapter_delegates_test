package com.bios.adapterdelegatestest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bios.adapterdelegatestest.models.adapters.AdapterBase
import com.bios.adapterdelegatestest.models.models.Animal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
    }

    private fun initRecycler() {
        val rv: RecyclerView = findViewById(R.id.rv)
        val adapter = AdapterBase()

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
        adapter.items = Animal.getRandomData()
    }
}
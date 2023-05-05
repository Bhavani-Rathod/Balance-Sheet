package com.bhavani.balance_sheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val dataList = listOf(
        Data("January", 10, 20),
        Data("Feb", 15, 25),
        Data("Mar", 20, 30),
        Data("Apr", 25, 35),
        Data("May", 30, 40),
        Data("Jun", 30, 40),
        Data("Jul", 30, 40),
        Data("Aug", 30, 40),
        Data("Sept", 30, 40),
        Data("Act", 30, 40),
        Data("Nov", 30, 40),
        Data("Dec", 30, 40)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(dataList)
    }
}





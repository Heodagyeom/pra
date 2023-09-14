package com.example.andsu2

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.andsu2.databinding.ActivityMain2Binding
import com.example.andsu2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 원본 준비
        val items = arrayOf<String?>(
            "item1",
            "item2",
            "item3",
            "item4",
            "item5",
            "item6",
            "item7",
            "item8",
            "item5",
            "item6",
            "item7",
            "item8",
            "item5",
            "item6",
            "item7",
            "item8",
            "item5",
            "item6",
            "item7",
            "item8"
        )

        //어댑터 준비 (배열 객체 이용, simple_list_item_1 리소스 사용
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, items)

        // 어댑터를 ListView 객체에 연결
        binding.ListView.adapter = adapter

//        binding.goToSecondButton.setOnClickListener {
//            val intent = Intent(this@MainActivity, ActivityMain2Binding::class.java)
//            startActivity(intent)
//
//        }
    }
}
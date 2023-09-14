package com.example.andsuweek4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btn = findViewById<Button>(R.id.bnt_close)
        btn.setOnClickListener {
            finish()
        }
    }
}
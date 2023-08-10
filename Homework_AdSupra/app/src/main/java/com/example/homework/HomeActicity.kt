package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActicity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_acticity)

        val tv_homeid_1 = findViewById<TextView>(R.id.tv_homeid_1)
        if(intent.hasExtra("baseid")){
            tv_homeid_1.text = intent.getStringExtra("baseid")
        }
        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            finish()
        }
    }
}
package com.example.andsu3_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_views)

        val btn = findViewById<Button>(R.id.bn_b2)
        btn.setOnClickListener{
            Toast.makeText(this, "액션 2번버튼이다", Toast.LENGTH_SHORT).show()
        }
    }
    fun doaction1(v: View){
        Toast.makeText(getApplicationContext(), "Action 1번이요", Toast.LENGTH_LONG).show()
    }
}
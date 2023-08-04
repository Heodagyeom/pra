package com.example.andsuweek4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class ThirdActivity : AppCompatActivity() {

    val TAG = "SecondActivity_Lifrcycle"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i(TAG, "onCreate()")
        setContentView(R.layout.activity_third)


        val strData = intent.getStringExtra("dataFromFirstActivity")
        val editText = findViewById<EditText>(R.id.editText)
        editText.setText(strData)

        val btn_close = findViewById<Button>(R.id.buttonThirdActivity)
        btn_close.setOnClickListener{
            finish()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy()")
    }

}
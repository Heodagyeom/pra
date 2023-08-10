package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val etvUpname = findViewById<EditText>(R.id.etv_upname)
        val etvUppw = findViewById<EditText>(R.id.etv_uppw)
        val etvUpid = findViewById<EditText>(R.id.etv_upid)

        val bntUpmember = findViewById<Button>(R.id.bnt_upmember)

        bntUpmember.setOnClickListener {
            if(
                etvUpname.text.toString().trim().isEmpty()||
                etvUpid.text.toString().trim().isEmpty()||
                etvUppw.text.toString().trim().isEmpty()){
                Toast.makeText(this, getString(R.string.up_toast_error), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            finish()
        }
    }
}
package com.example.homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignlnActicity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signln)

        val bnt_signLogin = findViewById<Button>(R.id.bnt_signlogin)
        val etv_signid = findViewById<EditText>(R.id.etv_signid)
        val etv_signpw = findViewById<EditText>(R.id.etv_signpw)
        val bnt_signmember = findViewById<Button>(R.id.bnt_signmember)

        bnt_signLogin.setOnClickListener {
            if(etv_signid.text.toString().trim().isEmpty() || etv_signpw.text.toString().trim().isEmpty()){
                Toast.makeText(this, getString(R.string.sign_toast_error),Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, HomeActicity::class.java)
            intent.putExtra("baseid", etv_signid.text.toString())
            startActivity(intent)
        }

        bnt_signmember.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
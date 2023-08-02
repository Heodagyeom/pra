package com.example.helloworld

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButton1Clicked(v: View) {
        Toast.makeText(this, "시작 버튼이 눌렸어요", Toast.LENGTH_SHORT).show()
    }// 알수없음이면 import 해주면된다. Toast 화면에 나오는거 확인바람 회색창에 알림처럼 뜬다. 작성법은 다음에

    fun onButton2Clicked(v: View) {
        val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse( "http://m.naver.com")) // uriString: 이거 직접치니깐 오류가 생겼었다.
        startActivity(myIntent) // Uri 가지고 액션뷰를 띄어서 start로 실행시켜라
    }

    fun onButton3Clicked(v: View) {
        val myIntent2 = Intent(Intent.ACTION_VIEW, Uri.parse( "tel: 010-1234-5678"))
        startActivity(myIntent2)
    }
}
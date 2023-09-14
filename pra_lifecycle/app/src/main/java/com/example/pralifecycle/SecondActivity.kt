package com.example.pralifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pralifecycle.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding
    val Tag = "2DaGyeom"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Tag, "2onCreate 를 했다. 일단 생성되는 부분") // 바로뜬다

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackmain.setOnClickListener {
            finish() //왜 여기서는 뒤로가기가 활성화되는가 그냥 앱이 꺼지지 않느다.
        }
    }
    override fun onStart(){
        super.onStart()
        Log.d(Tag, "2onStart 진행중 우리가 보여지는부분 화면에 나타난다.") //바로뜬다
    }

    override fun onResume(){
        super.onResume()
        Log.d(Tag, "2onResume 액티비티가 실행되고 있는 상태, 진행중이기도 하다.") //바로뜬다
    }

    override fun onPause(){
        super.onPause()
        Log.d(Tag, "2onPause 화면이 가려지고 액티비티 화면의 일!부!가 다른 액티비티에 가려진상태 ") //뒤로가기 누르면 1번째로실행되고
    }

    override fun onStop(){
        super.onStop()
        Log.d(Tag, "2onstop 화면이 없어지고 다른 액티비티가 실행되어서 화면이 완전히가려진상태") //pause 뒤에 1액티비티 start&resume 되고 실행
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Tag, "2onDestory 종료 완전 종료") // stop이후 바로 실행됨.
    }
}
package com.example.pralifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import com.example.pralifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    val Tag = "DaGyeom"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Tag, "onCreate 를 했다. 일단 생성되는 부분") // 바로뜬다

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bntGoSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java) // 꼭 인텐트를 넣어야지만 다음 페이지가 뜨는가?
            startActivity(intent)
//            startActivity(Intent(this,SecondActivity::class.java)) // intent 값을 넣으면 되기도 된다. intent 와 intent putExtra은 다르다 후자가 정보값을 전달
        }

        binding.bntGoFragment.setOnClickListener {
            setFragment(Fragment())
        }


    }
    private fun setFragment(frag : Fragment) {
        supportFragmentManager.commit{
            replace(R.id.frameLayout, frag)
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }

    override fun onStart(){
        super.onStart()
        Log.d(Tag, "onStart 진행중 우리가 보여지는부분 화면에 나타난다.") // 바로뜬다 -뒤로버튼누른뒤 2에서 일부가려지면서 실행
    }

    override fun onResume(){
        super.onResume()
        Log.d(Tag, "onResume 액티비티가 실행되고 있는 상태, 진행중이기도 하다.") // 바로뜬다 -뒤로버튼누른뒤 1start 실행뒤 바로 실행 그다음 2의 stop&Destory 실행
    }

    override fun onPause(){
        super.onPause()
        Log.d(Tag, "onPause 화면이 가려지고 액티비티 화면의 일!부!가 다른 액티비티에 가려진상태 ") //2번째누르니깐 뜬다. 그다음 2액티비티활성화 되기전 활성화되고
    }

    override fun onStop(){
        super.onStop()
        Log.d(Tag, "onstop 화면이 없어지고 다른 액티비티가 실행되어서 화면이 완전히가려진상태") // 2액티비티 3단계 진행되니 실행되면서 자동으로 같이 실행됨.
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Tag, "onDestory 종료 완전 종료")
    }

}

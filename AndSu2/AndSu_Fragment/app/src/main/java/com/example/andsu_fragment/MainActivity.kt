package com.example.andsu_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.andsu_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        binding.apply {
            fragment1Btn.setOnClickListener{
                setFragment(FirstFragment())
            }
            fragment2Btn.setOnClickListener {
                setFragment(SecondFragment())
            }
        }
        setFragment(FirstFragment())
    }

    private fun setFragment(frag : Fragment) {
        supportFragmentManager.commit {
            replace(R.id.frameLayout, frag)
            setReorderingAllowed(true)
            addToBackStack("")
        }

    }
}
// 코끼리 app 에 47번째줄을 추가
//
//
//
// 했다.
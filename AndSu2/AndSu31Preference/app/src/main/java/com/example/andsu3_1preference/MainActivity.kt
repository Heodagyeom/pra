package com.example.andsu3_1preference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.andsu3_1preference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mainBntSave.setOnClickListener {
            saveData() // 저장하는 함수 만들어서 호출하는 곳
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
        }
        loadData() // 화면다시 킬때 불러는 오는 값
    }
    private fun saveData(){
        val pref = getSharedPreferences("pref", 0) //0은 어디서 온것일까? sharedPreferences는 여러개가 가능
        val edit = pref.edit() //수정모드? edit은 컨트롤 마오를 눌러라
        edit.putString("name", binding.mainEdt.text.toString()) // 1번째 인자는 key, 두번째는 실제 담아둘 값
        edit.apply() //저장완료? apply 어디서 나왔니 이것도 컨트롤 마오를 눌르면 긴 초록글 보기
    }

     private fun loadData(){
         val pref = getSharedPreferences("pref",0)
         binding.mainEdt.setText(pref.getString("name",""))// 첫번째는 인자 key, 2번째 테이터가 존재하지 않을 시 넣을 값

     }
}
package com.example.andsu2

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.andsu2.databinding.ActivityMain2Binding
import com.example.andsu2.databinding.ActivityMainBinding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 원본 준비
        val items2 = arrayOf<String?>(
            "item1",
            "item2",
            "item3",
            "item4",
            "item5",
            "item6",
            "item7",
            "item8",
            "item5",
            "item6",
            "item7",
            "item8",
            "item5",
            "item6",
            "item7",
            "item8",
            "item5",
            "item6",
            "item7",
            "item8"
        )

        //어댑터 준비 (배열 객체 이용, simple_list_item_1 리소스 사용
        val adapter2 = ArrayAdapter(this, R.layout.simple_list_item_1, items2)

        // 어댑터를 GridView 객체에 연결
//        binding.gridView.adapter = adapter2 // 이렇게 하면서 adapter 이 오류가 생긴다. 참조할수없다고
        // 어댑터를 2개이상 사용할려면 액티비 파일을 따로 어댑터 전용으로 해서 class 를 선언하여 생선해야한다. GPT에 검색결과있음.
        binding.gridview.adapter = adapter2 // gird쪽에서 V 냐 v 냐에서 이거는 또 실행이 된다? 왜 뭐가 다른데?

//        binding.goToFirstButton.setOnClickListener {
//            val intent = Intent(this@MainActivity2, MainActivity::class.java)
//            startActivity(intent)
//
//        }
    }
}
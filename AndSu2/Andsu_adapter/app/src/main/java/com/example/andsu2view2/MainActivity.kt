package com.example.andsu2view2

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andsu2view2.databinding.ActivityMainBinding


//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_main)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // 데이터 원본 준비
//        val dataList = mutableListOf<MyItem>()
//        dataList.add(MyItem(R.drawable.img01, "Bella", "1"))
//        dataList.add(MyItem(R.drawable.img02, "Charlie", "2"))
//        dataList.add(MyItem(R.drawable.img03, "Daisy", "1.5"))
//        dataList.add(MyItem(R.drawable.img04, "Duke", "1"))
//        dataList.add(MyItem(R.drawable.img05, "Max", "2"))
//        dataList.add(MyItem(R.drawable.img06, "Happy", "4"))
//        dataList.add(MyItem(R.drawable.img07, "Luna", "3"))
//        dataList.add(MyItem(R.drawable.img08, "Bob", "2"))
//        dataList.add(MyItem(R.drawable.img09, "Da", "2"))
//        dataList.add(MyItem(R.drawable.img10, "Ba", "2"))
//        dataList.add(MyItem(R.drawable.img11, "Bo", "2"))
////
////
////        // 어댑터 생성 및 연결
////        binding.listView.adapter = MyAdapter(this, dataList)
////
////        // 항목 클릭 이벤트 처리
////        binding.listView.setOnItemClickListener{ parent, view, position, id ->
////            val name: String = (binding.listView.adapter.getItem(position) as MyItem).aName
////            Toast.makeText(this," $name 선택!", Toast.LENGTH_SHORT).show()
////        }
//
//        // recyclearview 부분
//        binding.recyclerView.adapter = MyAdapter(dataList) //context = this) 2
//
//        val adapter = MyAdapter(dataList)  // this)
//        binding.recyclerView.adapter = adapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//
//        adapter.itemClick = object : MyAdapter.ItemClick {
//            override fun onClick(view: View, position: Int) {
//                val name: String = dataList[position].aName
//                Toast.makeText(this@MainActivity, " $name 선택!", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}
// 어떤 이유인지 모르지만 main.xml 에서 9번째 줄이 이상한 글로 변해져있었따.
//view class="androidx.appcompat.app.AlertController$RecycleListView"
// 이렇게 이상하게 변해 있어서 지금 상태로 바뀌어주니 main액티비티 50줄에 중간 리사이클뷰가 작동이 되었다.
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 원본 준비
        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.img01, "Bella", "1"))
        dataList.add(MyItem(R.drawable.img02, "Charlie", "2"))
        dataList.add(MyItem(R.drawable.img03, "Daisy", "1.5"))
        dataList.add(MyItem(R.drawable.img04, "Duke", "1"))
        dataList.add(MyItem(R.drawable.img05, "Max", "2"))
        dataList.add(MyItem(R.drawable.img06, "Happy", "4"))
        dataList.add(MyItem(R.drawable.img07, "Luna", "3"))
        dataList.add(MyItem(R.drawable.img08, "Bob", "2"))
        dataList.add(MyItem(R.drawable.img09, "Da", "2"))
        dataList.add(MyItem(R.drawable.img10, "Ba", "2"))
        dataList.add(MyItem(R.drawable.img11, "Bo", "2"))
//
//
//        // 어댑터 생성 및 연결
//        binding.listView.adapter = MyAdapter(this, dataList)
//
//        // 항목 클릭 이벤트 처리
//        binding.listView.setOnItemClickListener{ parent, view, position, id ->
//            val name: String = (binding.listView.adapter.getItem(position) as MyItem).aName
//            Toast.makeText(this," $name 선택!", Toast.LENGTH_SHORT).show()
//        }

        // recyclearview 부분
        binding.recyclerView.adapter = MyAdapter(dataList, context = this)

        val adapter = MyAdapter(dataList,  this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = dataList[position].aName
                Toast.makeText(this@MainActivity, " $name 선택!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
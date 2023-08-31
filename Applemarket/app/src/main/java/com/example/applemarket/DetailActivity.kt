package com.example.applemarket

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.applemarket.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val dataList = mutableListOf<DummyItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            end()
        }

//        if (intent.hasExtra("byteArray")) {
//            val imv = ImageView(this)
//            val bitmap = BitmapFactory.decodeByteArray(
//                intent.getByteArrayExtra("byteArray"),
//                0,
//                intent.getByteArrayExtra("byteArray")!!.size
//            )
//            imv.setImageBitmap(bitmap)
//        } //앱 강제종료

        var a = intent.getStringExtra("pri")
        binding.tvITemDetailPrice.setText("$a 원") //null로 표시된다. 인트타입으로 보내서 오류발생. 통일시키자.

        var b = intent.getStringExtra("itemtilte")
        binding.tvItemTitle.setText(b)

        var c = intent.getStringExtra("del")
        binding.tvItemDetail.setText(c)

        var d = intent.getStringExtra("adr")
        binding.tvSellerAddress.setText(d)

        var e = intent.getStringExtra("name")
        binding.tvSellerName.setText(e)

        var f = intent.getIntExtra("image", 0)
        binding.ivItemImage.setImageResource(f) // 나는 int 로 보내놓고 String 로 받고 있어서 안되고 있다. 빨간줄이 되어 String을 int로 고칠생각은 안하고 뒤에 기본값과 f 에만 빨간줄을 열심히 수정하고 있었다. 조금 더 키워드에 공부가 필요하다.

        val adapter = ItemAdapter(context = this)
//        binding.constLayout.adapter = adapter
        adapter.setItems(dataList) // 이게 리스트를 부르는 것.
    }

    fun end() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}



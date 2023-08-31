package com.example.applemarket

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applemarket.databinding.ActivityMainBinding
import java.io.ByteArrayOutputStream


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataList = mutableListOf<DummyItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataList.add(
            DummyItem(
                R.drawable.sample1,
                "구매한지 한달된 선풍기 팝니다.",
                "이사가서 필요가 없저였어요 급하게 내놓습니다.",
                "홀길동",
                1000,
                "서울 서대문구 창천동",
                13,
                25,
                false
            )
        )
        dataList.add(
            DummyItem(
                R.drawable.sample2,
                "1구매한지 한달된 선풍기 팝니다.",
                "1이사가서 필요가 없저였어요 급하게 내놓습니다.",
                "홍길도2",
                2000,
                "1서울 서대문구 창천동",
                13,
                25,
                false
            )
        )
        dataList.add(
            DummyItem(
                R.drawable.sample3,
                "2구매한지 한달된 선풍기 팝니다.",
                "2이사가서 필요가 없저였어요 급하게 내놓습니다.",
                "홍길동3",
                3000,
                "2서울 서대문구 창천동",
                13,
                25,
                false
            )
        )
        dataList.add(
            DummyItem(
                R.drawable.sample4,
                "3구매한지 한달된 선풍기 팝니다.",
                "3이사가서 필요가 없저였어요 급하게 내놓습니다.",
                "홍길동4",
                4000,
                "3서울 서대문구 창천동",
                13,
                25,
                false
            )
        )
        dataList.add(
            DummyItem(
                R.drawable.sample5,
                "4구매한지 한달된 선풍기 팝니다.",
                "4이사가서 필요가 없저였어요 급하게 내놓습니다.",
                "홍길동5",
                5000,
                "4서울 서대문구 창천동",
                13,
                25,
                false
            )
        )
        dataList.add(
            DummyItem(
                R.drawable.sample6,
                "5구매한지 한달된 선풍기 팝니다.",
                "5이사가서 필요가 없저였어요 급하게 내놓습니다.",
                "홍길동6",
                6000,
                "5서울 서대문구 창천동",
                13,
                25,
                false
            )
        )
        dataList.add(
            DummyItem(
                R.drawable.sample7,
                "6구매한지 한달된 선풍기 팝니다.",
                "6이사가서 필요가 없저였어요 급하게 내놓습니다.",
                "홍길동7",
                7000,
                "6서울 서대문구 창천동",
                13,
                25,
                false
            )
        )
        dataList.add(
            DummyItem(
                R.drawable.sample8,
                "7구매한지 한달된 선풍기 팝니다.",
                "7이사가서 필요가 없저였어요 급하게 내놓습니다.",
                "홍길동8",
                8000,
                "7서울 서대문구 창천동",
                13,
                25,
                false
            )
        )
        dataList.add(
            DummyItem(
                R.drawable.sample9,
                "8구매한지 한달된 선풍기 팝니다.",
                "8이사가서 필요가 없저였어요 급하게 내놓습니다.",
                "홍길동9",
                9000,
                "8서울 서대문구 창천동",
                13,
                25,
                false
            )
        )
        dataList.add(
            DummyItem(
                R.drawable.sample10,
                "9구매한지 한달된 선풍기 팝니다.",
                "9이사가서 필요가 없저였어요 급하게 내놓습니다. 스크롤 확인용 글 길게 쓰기용 스크롤 확인용 글 길게 쓰기용 스크롤 확인용 글 길게 쓰기용 스크롤 확인용 글 길게 쓰기용 스크롤 확인용 글 길게 쓰기용 ",
                "홍길동310",
                10000,
                "9서울 서대문구 창천동",
                13,
                25,
                false
            )
        )

        // 벨눌렀을 때 작용하는 효과 fun부분에 복붙 알림 효과 넣음.
        binding.mainBarBell.setOnClickListener {
            notification()
        }

//        val datalist = mutableListOf<DummyItem>() // 필요없는 부분이었다. 맨위에 private로 선언해놓고 왜 또 선언

//        binding.recyclerView.adapter = ItemAdapter(datalist)

        val adapter = ItemAdapter(context = this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.setItems(dataList) // 이게 리스트를 부르는 것.

        adapter.itemClick = object : ItemAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
//                Toast.makeText(this@MainActivity, "선택!", Toast.LENGTH_SHORT).show()
                var select = dataList[position] //선택된
                val intent = Intent(this@MainActivity, DetailActivity::class.java)

//                val bitmap =
//                    BitmapFactory.decodeResource(resources, 0) // your bitmap
//
//                val bs = ByteArrayOutputStream()
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs)
//                intent.putExtra("byteArray", bs.toByteArray())

                intent.putExtra("image", select.Image)
                intent.putExtra("pri", select.Price.toString())
                intent.putExtra("itemtilte", select.ItemTitle)
                intent.putExtra("adr", select.Address)
                intent.putExtra("del", select.ItemDetail)
                intent.putExtra("name", select.SellerName)
                startActivity(intent)
            }
        }


    }

    fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 26 버전 이상
            val channelId = "one-channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                // 채널에 다양한 정보 설정
                description = "My Channel One Description"
                setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes)
                enableVibration(true)
            }

            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, channelId)

        } else {
            // 26 버전 이하
            builder = NotificationCompat.Builder(this)
        }

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_bell)
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        // 알림의 기본 정보
        builder.run {
            setSmallIcon(R.mipmap.ic_launcher)
            setWhen(System.currentTimeMillis())
            setContentTitle("키워드 알림")
            setContentText("설정한 키워드에 대한 알림이 도착했습니다.")
            setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("이부분은 복붙을 이용하여 해결하였는데,,, 정말 진심 복붙도 \n 왜 이렇게 안되는걸까요? 무엇이 잘못일까요? 갑갑하네요 \n Adapter 사용하면서 이해력에 문제가 있는 것 같네요")
            )
            setLargeIcon(bitmap)
            addAction(R.mipmap.ic_launcher, "Action", pendingIntent)
        }
        manager.notify(11, builder.build()) // 전구모양을 눌러서 무언가를 추가 했더니 빨간 줄 실종됨.
    }
}
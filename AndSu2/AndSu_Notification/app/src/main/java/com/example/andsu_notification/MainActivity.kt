package com.example.andsu_notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.andsu_notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.notificationButton.setOnClickListener {
            notification()
        }
    }

    fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //버전체크의 if
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
                setShowBadge(true) //뱃지 1,2 뜨는 부분이다. 알림오면 거슬리는 빨간동그라미지금 우측 상단에 초록동그라미 뜸
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes) // 소리부분. 일단 지금 기본 사운드
                enableVibration(true)
            }
            // 채널을 NotificationManager에 등록
            manager.createNotificationChannel(channel)

            // 채널을 이용하여 builder 생성
            builder = NotificationCompat.Builder(this, channelId)

        } else {
            // 26 버전 이하
            builder = NotificationCompat.Builder(this) // 8.0 이하에서 사용하는
        }

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.flower)
        val intent = Intent(this, SecondActivity::class.java)
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
            setWhen(System.currentTimeMillis()) //현재시간 =지금으로 일단 뜸           setContentTitle("새로운 알림입니다.") //타이틀 알림 위에 보이는 1순위
            setContentText("알림이 잘 보이시나요.") // 컨텐트에는 알림 위에 보이는 1순위
//            setStyle(
//                NotificationCompat.BigTextStyle()
//                    .bigText("이것은 긴텍스트 샘플입니다. 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다.이것은 긴텍스트 샘플입니다. \n 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다.이것은 긴텍스트 샘플입니다. \n 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다.")
//            ) // 긴글 넣는 법.
            setLargeIcon(bitmap)
            setStyle(NotificationCompat.BigPictureStyle()
                    .bigPicture(bitmap)
                    .bigLargeIcon(null))  // hide largeIcon while expanding
            addAction(R.mipmap.ic_launcher, "Action", pendingIntent)
        }


        manager.notify(11, builder.build())
    }

}
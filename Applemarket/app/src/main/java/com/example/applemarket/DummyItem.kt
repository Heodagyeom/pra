package com.example.applemarket

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize // 추천대로 anno 눌렀지만 @뒷부분이 달라서 직접 입력
data class DummyItem(
    val Image: Int,
    val ItemTitle: String,
    val ItemDetail: String,
    val SellerName: String,
    val Price: Int,
    val Address: String,
    val InterestCnt: Int,
    val ChatCnt: Int,
    var isLike: Boolean
): Parcelable
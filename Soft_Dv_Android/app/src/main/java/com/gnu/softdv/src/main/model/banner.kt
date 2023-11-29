package com.gnu.softdv.src.main.model

import com.google.gson.annotations.SerializedName

// 베너를 담을 데이터 클래스
data class banner(
    @SerializedName("img") val img:String
)

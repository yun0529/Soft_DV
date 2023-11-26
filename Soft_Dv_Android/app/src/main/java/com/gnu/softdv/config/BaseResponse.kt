package com.gnu.softdv.config

import com.google.gson.annotations.SerializedName

open class BaseResponse( // 모든 API 응답에 대한 기본 응답 형식
    @SerializedName("isSuccess") val isSuccess: Boolean = false,
    @SerializedName("code") val code: Int = 0,
    @SerializedName("message") val message: String? = null
)

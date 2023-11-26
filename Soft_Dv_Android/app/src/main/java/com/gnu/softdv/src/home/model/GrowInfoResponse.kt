package com.gnu.softdv.src.home.model

import com.gnu.softdv.config.BaseResponse
import com.google.gson.annotations.SerializedName

// API 기본 응답과 사육 정보를 담을 data class
data class GrowInfoResponse(
    @SerializedName("result") val result: Result
) : BaseResponse()

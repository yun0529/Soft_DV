package com.gnu.softdv.src.search.result.model

import com.gnu.softdv.config.BaseResponse
import com.google.gson.annotations.SerializedName

// 검색 결과를 API 응답 형식에 맞춰 저장할 데이터 클래스
data class SearchResponse(
    @SerializedName("result") val result: List<Result>?
) : BaseResponse()

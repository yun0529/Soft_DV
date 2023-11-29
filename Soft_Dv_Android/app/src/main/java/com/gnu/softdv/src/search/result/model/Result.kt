package com.gnu.softdv.src.search.result.model

import com.google.gson.annotations.SerializedName

// 검색 결과를 담을 데이터 클래스
data class Result(
    @SerializedName("index") val index : Int,
    @SerializedName("kind") val kind : String,
    @SerializedName("image") val image :String?,
    @SerializedName("scientificName") val scientificName : String
)
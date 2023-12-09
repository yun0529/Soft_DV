package com.gnu.softdv.src.home.model

import com.google.gson.annotations.SerializedName

// 사육 정보를 담을 data class
data class GetHomeGrowInfoResult(
    @SerializedName("scientificName") val scientificName : String,
    @SerializedName("image") val image : String
)

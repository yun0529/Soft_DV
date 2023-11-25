package com.gnu.softdv.src.search.model

import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("idx") val idx:Int,
    @SerializedName("image") val image:String,
    @SerializedName("name") val name:String,
    @SerializedName("content") val content:String
)

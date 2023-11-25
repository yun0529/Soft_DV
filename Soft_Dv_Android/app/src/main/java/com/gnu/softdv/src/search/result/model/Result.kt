package com.gnu.softdv.src.search.result.model

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("index") val index : Int,
    @SerializedName("kind") val kind : String,
    @SerializedName("image") val image :String?,
    @SerializedName("scientificName") val scientificName : String
)
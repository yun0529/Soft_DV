package com.gnu.softdv.src.home.model

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("insectInfoIndex") val insectInfoIndex : Int,
    @SerializedName("scientificName") val scientificName : String,
    @SerializedName("kind") val kind : String,
    @SerializedName("sizeMax") val sizeMax : Float,
    @SerializedName("lifeCycle") val lifeCycle : String,
    @SerializedName("image") val image : String,
    @SerializedName("location") val location : String,
    @SerializedName("breedTip") val breedTip : String,
)

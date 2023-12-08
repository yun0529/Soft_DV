package com.gnu.softdv.src.manage.model

import com.google.gson.annotations.SerializedName

data class GetManageList(
    @SerializedName("insectIdx") val insectIdx: Int,
    @SerializedName("groupIdx") val groupIdx: Int,
    @SerializedName("insectInfoIdx") val insectInfoIdx: Int,
    @SerializedName("family") val family: Int,
    @SerializedName("sex") val sex: String,
    @SerializedName("weight") val weight: Float,
    @SerializedName("size") val size: Float,
    @SerializedName("recommendTemperature") val recommendTemperature: Float,
    @SerializedName("recommendMoisture") val recommendMoisture: Float,
    @SerializedName("kind") val kind: String,
    @SerializedName("adult") val adult: Int,
    @SerializedName("image") val image: String,
)

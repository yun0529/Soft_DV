package com.gnu.softdv.src.manage.model

import com.google.gson.annotations.SerializedName

data class GetCurEnvResponse(
    @SerializedName("setTemperature") val setTemperature: Float,
    @SerializedName("curTemperature") val curTemperature: Float,
    @SerializedName("setMoisture") val setMoisture: Float,
    @SerializedName("curMoisture") val curMoisture: Float
)

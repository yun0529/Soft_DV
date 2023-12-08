package com.gnu.softdv.src.manage.model

import com.google.gson.annotations.SerializedName

data class PatchEnvRequest(
    @SerializedName("machineIdx") val machineIdx: Int,
    @SerializedName("temperature") val temperature: Float,
    @SerializedName("humidity") val humidity: Float
)
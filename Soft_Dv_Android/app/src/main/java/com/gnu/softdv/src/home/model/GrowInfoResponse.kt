package com.gnu.softdv.src.home.model

import com.gnu.softdv.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class GrowInfoResponse(
    @SerializedName("result") val result: Result
) : BaseResponse()

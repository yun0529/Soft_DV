package com.gnu.softdv.src.manage.model

import com.gnu.softdv.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class PatchEnvResponse(
    @SerializedName("result") val result: GetCurResponse
):BaseResponse()
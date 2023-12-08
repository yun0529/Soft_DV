package com.gnu.softdv.src.manage.model

import com.gnu.softdv.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class GetManageResponse(
    @SerializedName("result") val result: List<GetManageList>
):BaseResponse()

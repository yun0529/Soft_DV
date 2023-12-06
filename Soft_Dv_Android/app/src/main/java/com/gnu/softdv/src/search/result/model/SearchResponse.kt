package com.gnu.softdv.src.search.result.model

import com.gnu.softdv.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("result") val result: List<Result>?
) : BaseResponse()

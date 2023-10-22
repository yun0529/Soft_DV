package com.gnu.softdv.src.search.result

import com.gnu.softdv.src.search.result.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRetrofitInterface {
    @GET("app/search")
    fun getSearch(@Query("input") input : String
    ): Call<SearchResponse>
}
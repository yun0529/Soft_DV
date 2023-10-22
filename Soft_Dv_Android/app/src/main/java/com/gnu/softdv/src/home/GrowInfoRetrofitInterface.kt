package com.gnu.softdv.src.home

import com.gnu.softdv.src.home.model.GrowInfoResponse
import com.gnu.softdv.src.search.result.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GrowInfoRetrofitInterface {
    @GET("/products")
    fun getGrowInfo(@Query("userIdx") userIdx : Int,
                   @Query ("regionName") regionName : String
    ): Call<GrowInfoResponse>
}
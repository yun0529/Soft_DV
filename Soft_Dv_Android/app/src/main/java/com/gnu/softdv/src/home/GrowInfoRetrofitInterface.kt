package com.gnu.softdv.src.home

import com.gnu.softdv.src.home.model.GrowInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GrowInfoRetrofitInterface { // 사육 정보에 대한 API와 응답받을 데이터에 대해 선언하는 인터페이스
    @GET("/app/search/detail") // Get 메소드로 API 호출
    fun getGrowInfo(@Query("idx") idx : Int // Query Params 형태의 데이터를 서버로 송신
    ): Call<GrowInfoResponse> // GrowInfoResponse 형태로 응답을 받음
}
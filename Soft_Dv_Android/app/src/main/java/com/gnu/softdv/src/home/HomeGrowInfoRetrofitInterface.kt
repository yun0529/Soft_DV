package com.gnu.softdv.src.home

import com.gnu.softdv.src.home.model.GetHomeGrowInfoRequest
import com.gnu.softdv.src.home.model.GetHomeGrowInfoResult
import com.gnu.softdv.src.home.model.GrowInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeGrowInfoRetrofitInterface { // 사육 정보에 대한 API와 응답받을 데이터에 대해 선언하는 인터페이스
    @GET("/app/main/breedDetail") // Get 메소드로 API 호출
    fun getHomeGrowInfo( // Query Params 형태의 데이터를 서버로 송신
    ): Call<GetHomeGrowInfoRequest> // GrowInfoResponse 형태로 응답을 받음
}
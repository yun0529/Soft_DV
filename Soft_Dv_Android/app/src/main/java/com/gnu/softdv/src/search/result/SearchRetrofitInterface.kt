package com.gnu.softdv.src.search.result

import com.gnu.softdv.src.search.result.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRetrofitInterface { // 검색 결과에 대한 API와 응답받을 데이터에 대해 선언하는 인터페이스
    @GET("app/search") // Get 메소드로 API 호출
    fun getSearch(@Query("input") input : String // Query Params 형태의 데이터를 서버로 송신
    ): Call<SearchResponse> // SearchResponse 형태로 응답을 받음
}
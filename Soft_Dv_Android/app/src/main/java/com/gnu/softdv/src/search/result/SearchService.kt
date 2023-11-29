package com.gnu.softdv.src.search.result

import com.gnu.softdv.config.ApplicationClass
import com.gnu.softdv.src.search.SearchFragment
import com.gnu.softdv.src.search.result.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// 사육 정보 API를 호출하는 메소드를 정의하는 클래스
class SearchService (val searchFragment: SearchFragment) {
    fun tryGetSearchTotalGrow(input : String){ // 전체 검색 API를 호출하는 메소드
        val searchRetrofitInterface = ApplicationClass.retrofit.create(SearchRetrofitInterface::class.java)
        searchRetrofitInterface.getSearch(input).enqueue(object :
            Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                searchFragment.onGetSearchSuccess(response.body() as SearchResponse)
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                searchFragment.onGetSearchFailure(t.message ?: "통신 오류")
            }
        })
    }
}
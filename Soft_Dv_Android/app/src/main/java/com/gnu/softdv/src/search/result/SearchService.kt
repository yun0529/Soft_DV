package com.gnu.softdv.src.search.result

import androidx.fragment.app.Fragment
import com.gnu.softdv.config.ApplicationClass
import com.gnu.softdv.src.search.SearchFragment
import com.gnu.softdv.src.search.result.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchService (val searchFragment: SearchFragment) {
    fun tryGetSearchGrow(input : String){
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

    fun tryGetSearchTotalGrow(input : String){
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
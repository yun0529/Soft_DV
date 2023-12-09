package com.gnu.softdv.src.home

import com.gnu.softdv.config.ApplicationClass
import com.gnu.softdv.src.home.model.GetHomeGrowInfoRequest
import com.gnu.softdv.src.home.model.GrowInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// 사육 정보 API를 호출하는 메소드를 정의하는 클래스
class HomeGrowInfoService (val homeFragment: HomeFragment) {
    fun tryGetHomeGrowInfo(){ // 사육 정보 API를 호출하는 메소드
        val homeGrowInfoRetrofitInterface = ApplicationClass.retrofit.create(HomeGrowInfoRetrofitInterface::class.java)
        homeGrowInfoRetrofitInterface.getHomeGrowInfo().enqueue(object :
            Callback<GetHomeGrowInfoRequest> {
            override fun onResponse(call: Call<GetHomeGrowInfoRequest>, response: Response<GetHomeGrowInfoRequest>) { // 응답이 온 경우
                homeFragment.onGetHomeGrowInfoSuccess(response.body() as GetHomeGrowInfoRequest)
            }

            override fun onFailure(call: Call<GetHomeGrowInfoRequest>, t: Throwable) { // 호출 실패
                homeFragment.onGetHomeGrowInfoFailure(t.message ?: "통신 오류")
            }
        })
    }

}
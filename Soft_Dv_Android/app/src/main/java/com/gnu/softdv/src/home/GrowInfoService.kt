package com.gnu.softdv.src.home

import com.gnu.softdv.config.ApplicationClass
import com.gnu.softdv.src.home.model.GrowInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// 사육 정보 API를 호출하는 메소드를 정의하는 클래스
class GrowInfoService (val growInfoFragment: GrowInfoFragment) {
    fun tryGetGrowInfo(idx : Int){ // 사육 정보 API를 호출하는 메소드
        val growInfoRetrofitInterface = ApplicationClass.retrofit.create(GrowInfoRetrofitInterface::class.java)
        growInfoRetrofitInterface.getGrowInfo(idx).enqueue(object :
            Callback<GrowInfoResponse> {
            override fun onResponse(call: Call<GrowInfoResponse>, response: Response<GrowInfoResponse>) { // 응답이 온 경우
                growInfoFragment.onGetGrowInfoSuccess(response.body() as GrowInfoResponse)
            }

            override fun onFailure(call: Call<GrowInfoResponse>, t: Throwable) { // 호출 실패
                growInfoFragment.onGetGrowInfoFailure(t.message ?: "통신 오류")
            }
        })
    }

}
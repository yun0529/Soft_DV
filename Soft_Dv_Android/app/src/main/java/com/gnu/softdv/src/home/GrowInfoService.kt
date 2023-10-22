package com.gnu.softdv.src.home

import com.gnu.softdv.config.ApplicationClass
import com.gnu.softdv.src.home.model.GrowInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GrowInfoService (val growInfoFragment: GrowInfoFragment) {
    fun tryGetGrowInfo(userIdx : Int, regionName : String){
        val growInfoRetrofitInterface = ApplicationClass.retrofit.create(GrowInfoRetrofitInterface::class.java)
        growInfoRetrofitInterface.getGrowInfo(userIdx,regionName).enqueue(object :
            Callback<GrowInfoResponse> {
            override fun onResponse(call: Call<GrowInfoResponse>, response: Response<GrowInfoResponse>) {
                growInfoFragment.onGetGrowInfoSuccess(response.body() as GrowInfoResponse)
            }

            override fun onFailure(call: Call<GrowInfoResponse>, t: Throwable) {
                growInfoFragment.onGetGrowInfoFailure(t.message ?: "통신 오류")
            }
        })
    }

}
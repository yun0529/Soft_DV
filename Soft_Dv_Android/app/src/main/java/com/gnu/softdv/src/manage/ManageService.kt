package com.gnu.softdv.src.manage

import com.gnu.softdv.config.ApplicationClass
import com.gnu.softdv.src.manage.model.*
import com.gnu.softdv.src.search.SearchFragment
import com.gnu.softdv.src.search.result.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// 사육 정보 API를 호출하는 메소드를 정의하는 클래스
class ManageService (val manageFragment: ManageFragment) {
    fun tryGetEnv(){ // 전체 검색 API를 호출하는 메소드
        val manageRetrofitInterface = ApplicationClass.retrofit.create(ManageRetrofitInterface::class.java)
        manageRetrofitInterface.getMeasureCur().enqueue(object :
            Callback<CurEnvResult> {
            override fun onResponse(call: Call<CurEnvResult>, response: Response<CurEnvResult>) {
                manageFragment.onGetMeasureCurSuccess(response.body() as CurEnvResult)
            }

            override fun onFailure(call: Call<CurEnvResult>, t: Throwable) {
                manageFragment.onGetMeasureCurFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryPatchEnv(patchEnvRequest : PatchEnvRequest){ // 전체 검색 API를 호출하는 메소드
        val manageRetrofitInterface = ApplicationClass.retrofit.create(ManageRetrofitInterface::class.java)
        manageRetrofitInterface.patchEnv(patchEnvRequest).enqueue(object :
            Callback<PatchEnvResponse> {
            override fun onResponse(call: Call<PatchEnvResponse>, response: Response<PatchEnvResponse>) {
                manageFragment.onPatchEnvSuccess(response.body() as PatchEnvResponse)
            }

            override fun onFailure(call: Call<PatchEnvResponse>, t: Throwable) {
                manageFragment.onPatchEnvFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryGetManage(idx : Int){ // 전체 검색 API를 호출하는 메소드
        val manageRetrofitInterface = ApplicationClass.retrofit.create(ManageRetrofitInterface::class.java)
        manageRetrofitInterface.getManage(idx).enqueue(object :
            Callback<GetManageResponse> {
            override fun onResponse(call: Call<GetManageResponse>, response: Response<GetManageResponse>) {
                manageFragment.onGetManagerSuccess(response.body() as GetManageResponse)
            }

            override fun onFailure(call: Call<GetManageResponse>, t: Throwable) {
                manageFragment.onGetManagerFailure(t.message ?: "통신 오류")
            }
        })
    }
}
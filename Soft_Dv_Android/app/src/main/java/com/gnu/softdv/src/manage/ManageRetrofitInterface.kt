package com.gnu.softdv.src.manage

import com.gnu.softdv.src.manage.model.CurEnvResult
import com.gnu.softdv.src.manage.model.GetManageResponse
import com.gnu.softdv.src.manage.model.PatchEnvRequest
import com.gnu.softdv.src.manage.model.PatchEnvResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Query

interface ManageRetrofitInterface { // 검색 결과에 대한 API와 응답받을 데이터에 대해 선언하는 인터페이스
    @GET("app/main/breedEnv") // Get 메소드로 API 호출
    fun getMeasureCur(
    ): Call<CurEnvResult> // CurEnvResult 형태로 응답을 받음

    @PATCH("app/measure/set") // Get 메소드로 API 호출
    fun patchEnv(@Body params:PatchEnvRequest // RequestBody 형태의 데이터를 서버로 송신
    ): Call<PatchEnvResponse> // SearchResponse 형태로 응답을 받음

    @GET("app/measure/manage") // Get 메소드로 API 호출
    fun getManage(@Query("group")group:Int // RequestBody 형태의 데이터를 서버로 송신
    ): Call<GetManageResponse> // SearchResponse 형태로 응답을 받음
}
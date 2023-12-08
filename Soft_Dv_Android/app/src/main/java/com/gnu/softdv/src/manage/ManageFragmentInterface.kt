package com.gnu.softdv.src.manage

import com.gnu.softdv.src.manage.model.CurEnvResult
import com.gnu.softdv.src.manage.model.GetManageResponse
import com.gnu.softdv.src.manage.model.PatchEnvResponse

interface ManageFragmentInterface { // 검색 API 처리에 대한 인터페이스
    fun onGetMeasureCurSuccess(response: CurEnvResult) // 응답을 성공적으로 받음

    fun onGetMeasureCurFailure(message: String) // 응답을 받지 못함

    fun onPatchEnvSuccess(response: PatchEnvResponse) // 응답을 성공적으로 받음

    fun onPatchEnvFailure(message: String) // 응답을 받지 못함

    fun onGetManagerSuccess(response: GetManageResponse) // 응답을 성공적으로 받음

    fun onGetManagerFailure(message: String) // 응답을 받지 못함
}
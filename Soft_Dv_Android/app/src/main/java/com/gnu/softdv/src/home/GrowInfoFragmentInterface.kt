package com.gnu.softdv.src.home

import com.gnu.softdv.src.home.model.GrowInfoResponse


interface GrowInfoFragmentInterface { // 사육 정보 처리에 대한 인터페이스
    fun onGetGrowInfoSuccess(response: GrowInfoResponse) // 응답을 성공적으로 받음

    fun onGetGrowInfoFailure(message: String) // 응답을 받지 못함
}
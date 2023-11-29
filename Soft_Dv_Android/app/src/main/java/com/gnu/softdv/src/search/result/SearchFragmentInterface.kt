package com.gnu.softdv.src.search.result

import com.gnu.softdv.src.search.result.model.SearchResponse

interface SearchFragmentInterface { // 검색 API 처리에 대한 인터페이스
    fun onGetSearchSuccess(response: SearchResponse) // 응답을 성공적으로 받음

    fun onGetSearchFailure(message: String) // 응답을 받지 못함
}
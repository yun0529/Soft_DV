package com.gnu.softdv.src.search.result

import com.gnu.softdv.src.search.result.model.SearchResponse

interface SearchFragmentInterface {
    fun onGetSearchSuccess(response: SearchResponse)

    fun onGetSearchFailure(message: String)
}
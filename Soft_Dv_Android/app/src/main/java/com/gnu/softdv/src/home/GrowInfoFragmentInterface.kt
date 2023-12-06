package com.gnu.softdv.src.home

import com.gnu.softdv.src.home.model.GrowInfoResponse


interface GrowInfoFragmentInterface {
    fun onGetGrowInfoSuccess(response: GrowInfoResponse)

    fun onGetGrowInfoFailure(message: String)
}
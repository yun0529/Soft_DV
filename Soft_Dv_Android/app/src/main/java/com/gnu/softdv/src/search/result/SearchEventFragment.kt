package com.gnu.softdv.src.search.result

import android.os.Bundle
import android.view.View
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentSearchEventBinding

// 검색한 내용중 이벤트 관련 내용을 출력하는 클래스
class SearchEventFragment  : BaseFragment<FragmentSearchEventBinding>(
    FragmentSearchEventBinding::bind, R.layout.fragment_search_event
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // 프래그먼트 실행과 동시에 호출되는 생명주기
        super.onViewCreated(view, savedInstanceState)



    }
}
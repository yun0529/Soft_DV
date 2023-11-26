package com.gnu.softdv.src.event

import android.os.Bundle
import android.view.View
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentEventBinding

// 이벤트를 출력할 프래그먼트
class EventFragment  : BaseFragment<FragmentEventBinding>(
    FragmentEventBinding::bind, R.layout.fragment_event
) { // 프래그먼트 실행과 동시에 호출되는 생명주기
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
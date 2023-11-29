package com.gnu.softdv.src.setting

import android.os.Bundle
import android.view.View
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentSettingBinding

// 설정 레이아웃을 출력하는 프래그먼트
class SettingFragment  : BaseFragment<FragmentSettingBinding>(
    FragmentSettingBinding::bind, R.layout.fragment_setting
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // 프래그먼트 실행과 동시에 호출되는 생명주기
        super.onViewCreated(view, savedInstanceState)

    }
}
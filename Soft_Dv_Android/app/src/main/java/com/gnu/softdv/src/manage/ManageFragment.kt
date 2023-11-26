package com.gnu.softdv.src.manage

import android.os.Bundle
import android.view.View
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentManageBinding

class ManageFragment  : BaseFragment<FragmentManageBinding>(
    FragmentManageBinding::bind, R.layout.fragment_manage
) { // 프래그먼트 실행과 동시에 호출되는 생명주기
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
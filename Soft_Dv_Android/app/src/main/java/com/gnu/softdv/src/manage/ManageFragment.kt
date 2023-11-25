package com.gnu.softdv.src.manage

import android.os.Bundle
import android.view.View
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentManageBinding

class ManageFragment  : BaseFragment<FragmentManageBinding>(
    FragmentManageBinding::bind, R.layout.fragment_manage
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
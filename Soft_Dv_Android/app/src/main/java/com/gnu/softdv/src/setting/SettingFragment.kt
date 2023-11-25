package com.gnu.softdv.src.setting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentEventBinding
import com.gnu.softdv.databinding.FragmentManageBinding
import com.gnu.softdv.databinding.FragmentSettingBinding

class SettingFragment  : BaseFragment<FragmentSettingBinding>(
    FragmentSettingBinding::bind, R.layout.fragment_setting
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
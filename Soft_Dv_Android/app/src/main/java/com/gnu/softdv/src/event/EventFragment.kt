package com.gnu.softdv.src.event

import android.os.Bundle
import android.view.View
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentEventBinding

class EventFragment  : BaseFragment<FragmentEventBinding>(
    FragmentEventBinding::bind, R.layout.fragment_event
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
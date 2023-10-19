package com.gnu.softdv.src.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentEventBinding
import com.gnu.softdv.databinding.FragmentManageBinding
import com.gnu.softdv.databinding.FragmentSearchBinding
import com.gnu.softdv.databinding.FragmentSettingBinding

class SearchFragment  : BaseFragment<FragmentSearchBinding>(
    FragmentSearchBinding::bind, R.layout.fragment_search
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    // viewPager 세팅
    private fun initViewPager() {
        viewPagers = binding.resultVp
        tabLayouts = binding.searchTbl

        var adapter = SearchAdapter(requireActivity().supportFragmentManager)
        adapter.addFragment(BookmarksAllFragment(), "통합")
        adapter.addFragment(BookmarksScholarshipFragment(), "사육정보")
        adapter.addFragment(BookmarksSupportFragment(), "사육업소")
        adapter.addFragment(BookmarksPostFragment(), "이벤트")

        viewPagers!!.adapter = adapter
        tabLayouts!!.setupWithViewPager(viewPagers)

    }
}
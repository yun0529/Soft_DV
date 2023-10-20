package com.gnu.softdv.src.search

import android.os.Bundle
import android.view.View
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentSearchBinding
import com.gnu.softdv.src.MainActivity
import com.gnu.softdv.src.search.result.SearchCompInfoFragment
import com.gnu.softdv.src.search.result.SearchGrowInfoFragment
import com.gnu.softdv.src.search.result.SearchEventFragment
import com.gnu.softdv.src.search.result.SearchTotalFragment

class SearchFragment  : BaseFragment<FragmentSearchBinding>(
    FragmentSearchBinding::bind, R.layout.fragment_search
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()


    }

    // viewPager 세팅
    private fun initViewPager() {

        var sAdapter = SearchVPAdapter((activity as MainActivity).supportFragmentManager)
        sAdapter.addFragment(SearchTotalFragment(), "통합")
        sAdapter.addFragment(SearchGrowInfoFragment(), "사육정보")
        sAdapter.addFragment(SearchCompInfoFragment(), "사육업소")
        sAdapter.addFragment(SearchEventFragment(), "이벤트")

        binding.resultVp.adapter = sAdapter

        binding.searchTbl.setupWithViewPager(binding.resultVp)

    }
}
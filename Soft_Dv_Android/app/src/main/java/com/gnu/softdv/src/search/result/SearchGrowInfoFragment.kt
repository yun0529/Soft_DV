package com.gnu.softdv.src.search.result

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gnu.softdv.R
import com.gnu.softdv.config.ApplicationClass.Companion.searchArray
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentSearchGrowInfoBinding
import com.gnu.softdv.src.MainActivity
import com.gnu.softdv.src.search.SearchAdapter
import com.gnu.softdv.src.search.result.model.SearchResponse

// 검색한 내용중 사육 정보 관련 내용을 출력하는 클래스
class SearchGrowInfoFragment  : BaseFragment<FragmentSearchGrowInfoBinding>(
    FragmentSearchGrowInfoBinding::bind, R.layout.fragment_search_grow_info), SearchFragmentInterface {
    //private var growSet = arrayListOf<SearchResult>()
    private lateinit var growInfoAdapter: SearchAdapter // 사육 정보와 리사이클러뷰를 엮어줄 어뎁터 선언

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("test",searchArray.size.toString())
        growInfoAdapter = SearchAdapter(context as MainActivity,searchArray,0) // 내용을 출력할 어뎁터 연결
        // 리사이클러뷰의 형태 정의
        binding.rvGrow.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        // 리사이클러뷰의 각 아이템 사이 구분선 정의
        binding.rvGrow.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        binding.rvGrow.adapter = growInfoAdapter // 어뎁터 연결

    }

    override fun onGetSearchSuccess(response: SearchResponse) { // 검색 API 호출 성공
        TODO("Not yet implemented")
    }

    override fun onGetSearchFailure(message: String) { // 검색 API 호출 실패
        TODO("Not yet implemented")
    }
}
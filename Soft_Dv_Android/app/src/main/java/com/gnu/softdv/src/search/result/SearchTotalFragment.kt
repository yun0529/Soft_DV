package com.gnu.softdv.src.search.result

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentSearchTotalBinding
import com.gnu.softdv.src.MainActivity
import com.gnu.softdv.src.search.SearchAdapter
import com.gnu.softdv.src.search.SearchFragment
import com.gnu.softdv.src.search.result.model.SearchResponse
import com.gnu.softdv.config.ApplicationClass.Companion.searchArray

// 전체 검색 결과를 출력할 프래그먼트
class SearchTotalFragment  : BaseFragment<FragmentSearchTotalBinding>(FragmentSearchTotalBinding::bind,
    R.layout.fragment_search_total), SearchFragmentInterface {
    private lateinit var growInfoAdapter: SearchAdapter // 검색 결과를 리사이클러뷰에 출력할 어뎁터 선언
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {// 프래그먼트 실행과 동시에 호출되는 생명주기
        super.onViewCreated(view, savedInstanceState)

        // 검색 결과의 개수에 따라 출력 형식 지정
        if(searchArray.size == 0){ // 검색 결과가 없음을 출력
            binding.btnGrowInfoMore.visibility = View.GONE
            binding.tvGrow.visibility = View.GONE
            growInfoAdapter = SearchAdapter(context as MainActivity,searchArray,0)
        }else{ // 데이터 출력
            //binding.btnGrowInfoMore.visibility = View.VISIBLE
            //binding.tvGrow.visibility = View.VISIBLE
            growInfoAdapter = SearchAdapter(context as MainActivity,searchArray,0)
        }

        // 리사이클러뷰의 형태 정의
        binding.rvGrow.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvGrow.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL)) // 리사이클러뷰의 각 아이템 사이 구분선 정의
        binding.rvGrow.adapter = growInfoAdapter // 어뎁터 연결

        binding.btnGrowInfoMore.setOnClickListener { // 검색 결과 더보기를 눌렸을 경우 해당 검색 결과 탭으로 이동
            SearchFragment().setTab(1)
        }

    }

    override fun onGetSearchSuccess(response: SearchResponse) { // 검색 API 호출 성공

    }

    override fun onGetSearchFailure(message: String) { // 검색 API 호출 실패
        showCustomToast(message)
    }


}
package com.gnu.softdv.src.search.result

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentSearchGrowInfoBinding
import com.gnu.softdv.src.MainActivity
import com.gnu.softdv.src.search.SearchAdapter
import com.gnu.softdv.src.search.model.SearchResult
import com.gnu.softdv.src.search.result.model.SearchResponse
import net.daum.android.map.MapView

class SearchGrowInfoFragment  : BaseFragment<FragmentSearchGrowInfoBinding>(
    FragmentSearchGrowInfoBinding::bind, R.layout.fragment_search_grow_info), SearchFragmentInterface {
    private var growSet = arrayListOf<SearchResult>()
    private lateinit var growInfoAdapter: SearchAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        growSet.add(SearchResult("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg", "벌레", "벌레같네.."))
        growSet.add(SearchResult("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg", "벌레", "벌레같네.."))
        growSet.add(SearchResult("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg", "벌레", "벌레같네.."))
        growSet.add(SearchResult("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg", "벌레", "벌레같네.."))
        growSet.add(SearchResult("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg", "벌레", "벌레같네.."))
        growSet.add(SearchResult("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg", "벌레", "벌레같네.."))
        Log.d("test",growSet.size.toString())
        growInfoAdapter = SearchAdapter(context as MainActivity,growSet)
        binding.rvGrow.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvGrow.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        binding.rvGrow.adapter = growInfoAdapter

    }

    override fun onGetSearchSuccess(response: SearchResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetSearchFailure(message: String) {
        TODO("Not yet implemented")
    }
}
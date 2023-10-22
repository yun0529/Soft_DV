package com.gnu.softdv.src.search.result

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gnu.softdv.R
import com.gnu.softdv.config.ApplicationClass.Companion.editor
import com.gnu.softdv.config.ApplicationClass.Companion.sDB
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentSearchTotalBinding
import com.gnu.softdv.src.MainActivity
import com.gnu.softdv.src.search.SResult
import com.gnu.softdv.src.search.SearchAdapter
import com.gnu.softdv.src.search.model.SearchResult
import com.gnu.softdv.src.search.result.model.SearchResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class SearchTotalFragment  : BaseFragment<FragmentSearchTotalBinding>(FragmentSearchTotalBinding::bind,
    R.layout.fragment_search_total), SearchFragmentInterface {
    private var growSet = arrayListOf<SearchResult>()
    private lateinit var growInfoAdapter: SearchAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGrowInfoMore.visibility = View.VISIBLE
        val preferences = context?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        if(preferences?.getString("searchResult", "").toString() != ""){
            val jsonData = preferences?.getString("searchResult", "")

            val gson = Gson()
            val token: TypeToken<MutableList<SResult>> = object : TypeToken<MutableList<SResult>>(){}
            val list: MutableList<SResult>? = gson.fromJson(jsonData, token.type)

            if(list?.isEmpty()!!){
                binding.btnGrowInfoMore.visibility = View.GONE
            }else{
                binding.btnGrowInfoMore.visibility = View.VISIBLE
            }
            for(i in 0 until list.size){
                growSet.add(SearchResult(list[i].image,list[i].kind,list[i].scientificName))
                Log.d("apitest",growSet.toString())
            }
        }

        //growSet.add(SearchResult("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg", "벌레", "벌레같네.."))
        //growSet.add(SearchResult("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg", "벌레", "벌레같네.."))
        //growSet.add(SearchResult("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg", "벌레", "벌레같네.."))
        //growSet.add(SearchResult("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg", "벌레", "벌레같네.."))
        Log.d("test",growSet.size.toString())
        growInfoAdapter = SearchAdapter(context as MainActivity,growSet)
        binding.rvGrow.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvGrow.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        binding.rvGrow.adapter = growInfoAdapter

    }

    override fun onGetSearchSuccess(response: SearchResponse) {
        for(i in 0 until response.result?.size!!){
            growSet.add(SearchResult(response.result?.get(i)?.image.toString(), response.result?.get(i)?.kind.toString(), response.result?.get(i)?.scientificName.toString()))
        }
        if(response.result?.isNotEmpty()!!){
            binding.btnGrowInfoMore.visibility = View.VISIBLE
        }
        growInfoAdapter.notifyDataSetChanged()
    }

    override fun onGetSearchFailure(message: String) {
        showCustomToast(message)
    }
}
package com.gnu.softdv.src.search.result

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.gnu.softdv.R
import com.gnu.softdv.config.ApplicationClass.Companion.editor
import com.gnu.softdv.config.ApplicationClass.Companion.sDB
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentSearchTotalBinding
import com.gnu.softdv.src.MainActivity
import com.gnu.softdv.src.search.SResult
import com.gnu.softdv.src.search.SearchAdapter
import com.gnu.softdv.src.search.SearchFragment
import com.gnu.softdv.src.search.model.SearchResult
import com.gnu.softdv.src.search.result.model.SearchResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import com.gnu.softdv.config.ApplicationClass.Companion.searchArray
import com.gnu.softdv.src.search.TabSelectInterface

class SearchTotalFragment  : BaseFragment<FragmentSearchTotalBinding>(FragmentSearchTotalBinding::bind,
    R.layout.fragment_search_total), SearchFragmentInterface {
    private var growSet = arrayListOf<SearchResult>()
    private lateinit var growInfoAdapter: SearchAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(searchArray.size == 0){
            binding.btnGrowInfoMore.visibility = View.GONE
            binding.tvGrow.visibility = View.GONE
            growInfoAdapter = SearchAdapter(context as MainActivity,searchArray,0)
        }else{
            //binding.btnGrowInfoMore.visibility = View.VISIBLE
            //binding.tvGrow.visibility = View.VISIBLE
            growInfoAdapter = SearchAdapter(context as MainActivity,searchArray,0)
        }

        binding.rvGrow.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvGrow.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        binding.rvGrow.adapter = growInfoAdapter

        binding.btnGrowInfoMore.setOnClickListener {
            SearchFragment().setTab(1)
        }

    }

    override fun onGetSearchSuccess(response: SearchResponse) {
//        for(i in 0 until response.result?.size!!){
//            growSet.add(SearchResult(response.result?.get(i)?.image.toString(), response.result?.get(i)?.kind.toString(), response.result?.get(i)?.scientificName.toString()))
//        }
//        if(response.result?.isNotEmpty()!!){
//            binding.btnGrowInfoMore.visibility = View.VISIBLE
//        }
//        growInfoAdapter.notifyDataSetChanged()
    }

    override fun onGetSearchFailure(message: String) {
        showCustomToast(message)
    }

//    override fun onResume() {
//        super.onResume()
//        val preferences = sDB
//        if(preferences.getString("searchResult", "").toString() != ""){
//
//            val jsonData = preferences.getString("searchResult", "")
//            Log.d("JSON",jsonData.toString())
//            val gson = Gson()
//            val token: TypeToken<MutableList<SResult>> = object : TypeToken<MutableList<SResult>>(){}
//            val list: MutableList<SResult>? = gson.fromJson(jsonData, token.type)
//
//            if(list?.isEmpty() == true){
//                binding.btnGrowInfoMore.visibility = View.GONE
//            }else{
//                binding.btnGrowInfoMore.visibility = View.VISIBLE
//            }
//            if (list != null) {
//                for(i in 0 until list.size){
//                    growSet.add(SearchResult(list?.get(i)?.image.toString(),
//                        list?.get(i)?.kind.toString(), list?.get(i)?.scientificName.toString()))
//                    Log.d("apitest",growSet.toString())
//                }
//            }
//            growInfoAdapter.notifyDataSetChanged()
//        }
//
//    }

}
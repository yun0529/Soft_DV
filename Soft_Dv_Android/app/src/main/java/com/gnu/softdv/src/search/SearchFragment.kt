package com.gnu.softdv.src.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentSearchBinding
import com.gnu.softdv.src.MainActivity
import com.gnu.softdv.src.home.GrowInfoFragment
import com.gnu.softdv.src.search.result.*
import com.gnu.softdv.src.search.result.model.SearchResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


data class SResult(    val index : Int,
                      val kind : String,
                      val image :String,
                      val scientificName : String
)

class SearchFragment  : BaseFragment<FragmentSearchBinding>(
    FragmentSearchBinding::bind, R.layout.fragment_search
), SearchFragmentInterface {
    private lateinit var sAdapter : SearchVPAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
        binding.search.imeOptions = EditorInfo.IME_ACTION_DONE

        //binding.search.setOnEditorActionListener()

        binding.search.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                SearchService(this@SearchFragment).tryGetSearchTotalGrow(binding.search.text.toString())
                Log.d("api",binding.search.text.toString())
                true
            } else false
        })


    }

    // viewPager 세팅
    private fun initViewPager() {

        sAdapter = SearchVPAdapter((activity as MainActivity).supportFragmentManager)
        sAdapter.addFragment(SearchTotalFragment(), "통합")
        sAdapter.addFragment(SearchGrowInfoFragment(), "사육정보")
        sAdapter.addFragment(SearchCompInfoFragment(), "사육업소")
        sAdapter.addFragment(SearchEventFragment(), "이벤트")

        binding.resultVp.adapter = sAdapter

        binding.searchTbl.setupWithViewPager(binding.resultVp)

    }

    override fun onGetSearchSuccess(response: SearchResponse) {
        val preferences = context?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val jsonData = preferences?.getString("searchResult", "")

        val gson = Gson()
        val token: TypeToken<MutableList<SResult>> = object : TypeToken<MutableList<SResult>>(){}
        val list: MutableList<SResult>? = gson.fromJson(jsonData, token.type)
        for(i in 0 until response.result!!.size){
            list?.add(SResult(response.result[i].index,
                response.result[i].kind,
                response.result[i].image.toString(),
                response.result[i].scientificName))
        }

        val editor = preferences?.edit()
        editor?.putString("person", gson.toJson(list, token.type))
        editor?.apply()

        refreshFragment(SearchTotalFragment(),(context as MainActivity).supportFragmentManager)

//        (context as MainActivity).supportFragmentManager.beginTransaction()
//            .replace(R.id.result_vp, SearchTotalFragment())
//            .commit()

//        var a = SearchVPAdapter((activity as MainActivity).supportFragmentManager)
//        a.addFragment(SearchTotalFragment(), "통합")
//        a.addFragment(SearchGrowInfoFragment(), "사육정보")
//        a.addFragment(SearchCompInfoFragment(), "사육업소")
//        a.addFragment(SearchEventFragment(), "이벤트")
//
//        binding.resultVp.adapter = a
//        binding.searchTbl.setupWithViewPager(binding.resultVp)

    }

    override fun onGetSearchFailure(message: String) {
        showCustomToast(message)
    }
    fun refreshFragment(fragment: Fragment, fragmentManager: FragmentManager) {
        var ft: FragmentTransaction = fragmentManager.beginTransaction()
        ft.detach(fragment).attach(fragment).commit()
    }
}
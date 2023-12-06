package com.gnu.softdv.src.search

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.gnu.softdv.R
import com.gnu.softdv.config.ApplicationClass.Companion.searchArray
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentSearchBinding
import com.gnu.softdv.src.MainActivity
import com.gnu.softdv.src.search.model.SearchResult
import com.gnu.softdv.src.search.result.*
import com.gnu.softdv.src.search.result.model.SearchResponse


data class SResult(val index : Int,
                      val kind : String,
                      val image :String,
                      val scientificName : String
)

class SearchFragment  : BaseFragment<FragmentSearchBinding>(
    FragmentSearchBinding::bind, R.layout.fragment_search
), SearchFragmentInterface, TabSelectInterface {
    lateinit var sAdapter : SearchVPAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
        binding.search.imeOptions = EditorInfo.IME_ACTION_DONE

        //binding.search.setOnEditorActionListener()

        binding.search.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                SearchService(this@SearchFragment).tryGetSearchTotalGrow(binding.search.text.toString())


//                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//                inputMethodManager.hideSoftInputFromWindow(binding.search.windowToken, 0)

                //Log.d("api",binding.search.text.toString())
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
        searchArray = arrayListOf()

        for(i in 0 until response.result!!.size){
            searchArray.add(
                SearchResult(
                response.result[i].index,
                response.result[i].image.toString(),
                response.result[i].kind,
                response.result[i].scientificName))
        }

        Log.d("arrayTest", searchArray.toString())
        sAdapter.notifyDataSetChanged()
        if(searchArray.size == 0){
            binding.clOff.visibility = View.VISIBLE
        }else{
            binding.clOff.visibility = View.GONE
        }
        //refreshFragment(SearchTotalFragment(),(context as MainActivity).supportFragmentManager)


    }

    override fun onGetSearchFailure(message: String) {
        showCustomToast(message)
    }
    private fun refreshFragment(fragment: Fragment, fragmentManager: FragmentManager) {
        var ft: FragmentTransaction = fragmentManager.beginTransaction()
        ft.detach(fragment).attach(fragment).commit()
    }

    override fun setTab(num: Int) {
        Log.d("Tba",binding.searchTbl.getTabAt(1).toString())
        //binding.resultVp.currentItem = sAdapter.getItemPosition()
//        binding.resultVp.setCurrentItem(num,true)
////        binding.searchTbl.selectTab(num)
////        selectedTabPosition(num)
//
//        val tabLayout = findViewById(R.id.tabs) as TabLayout
        //val tab = binding.searchTbl.getTabAt(1)
        //tab!!.select()

    }
}
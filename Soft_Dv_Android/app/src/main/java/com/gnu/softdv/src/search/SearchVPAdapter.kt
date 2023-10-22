package com.gnu.softdv.src.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class SearchVPAdapter (manager: FragmentManager): FragmentPagerAdapter(manager) {

    private var fragmentList: MutableList<Fragment> = arrayListOf()
    private var titleList: MutableList<String> = arrayListOf()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }


    fun addFragment(fragment: Fragment, title: String){
        fragmentList.add(fragment)
        titleList.add(title)
    }

//    fun changeFragment(fragment: Fragment, position: Int){
//        fragmentList.add(fragment)
//        titleList.add(title)
//    }

}
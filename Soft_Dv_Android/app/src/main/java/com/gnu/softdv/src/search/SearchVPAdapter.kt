package com.gnu.softdv.src.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

// 검색 카테고리를 뷰페이저에 엮어주는 어뎁터
class SearchVPAdapter (manager: FragmentManager): FragmentPagerAdapter(manager) {

    private var fragmentList: MutableList<Fragment> = arrayListOf() // 프래그먼트를 저장하는 리스트
    private var titleList: MutableList<String> = arrayListOf() // 프래그먼트의 타이틀을 저장하는 리스트

    override fun getItem(position: Int): Fragment { // 위치에 해당하는 프래그먼트를 반환
        return fragmentList[position]
    }

    override fun getCount(): Int { // 뷰페이저에 담긴 프래그먼트의 개수를 반환
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? { // 프래그먼트의 타이틀을 반환하는 메소드
        return titleList[position]
    }

    override fun getItemPosition(`object`: Any): Int { // 뷰의 위치를 반환하는 메소드
        return POSITION_NONE
    }

    fun addFragment(fragment: Fragment, title: String){
        fragmentList.add(fragment) // 해당하는 프래그먼트를 추가
        titleList.add(title) // 해당하는 프래그먼트의 타이틀을 추가
    }

}
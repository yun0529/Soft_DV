package com.gnu.softdv.src

import android.os.Bundle
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseActivity
import com.gnu.softdv.databinding.ActivityMainBinding
import com.gnu.softdv.src.home.HomeFragment
import com.gnu.softdv.src.manage.ManageFragment
import com.gnu.softdv.src.search.SearchFragment
import com.gnu.softdv.src.setting.SettingFragment

// 가장 기본이 되는 메인 액티비티에 대한 클래스
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) { // 액티비티 실행과 동시에 호출되는 생명주기
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction() // 앱 실행시 가장 먼저 출력될 프래그먼트를 지정
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener{ item -> // 바텀 네비게이션 뷰의 각 카테고리를 클릭했을 때 발생하는 화면전환 이벤트
            when (item.itemId) {
                R.id.home -> { // 홈 페이지로 이동
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.manage -> { // 사육 관리 페이지로 이동
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, ManageFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.search -> { // 검색 페이지로 이동
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.setting -> { // 설정 페이지로 이동
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SettingFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

}
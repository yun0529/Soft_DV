package com.gnu.softdv.src

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseActivity
import com.gnu.softdv.databinding.ActivityMainBinding
import com.gnu.softdv.src.event.EventFragment
import com.gnu.softdv.src.home.HomeFragment
import com.gnu.softdv.src.main.BannerAdapter
import com.gnu.softdv.src.main.model.banner
import com.gnu.softdv.src.manage.ManageFragment
import com.gnu.softdv.src.search.SearchFragment
import com.gnu.softdv.src.setting.SettingFragment
import okhttp3.internal.notifyAll
import java.security.MessageDigest

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener{ item ->
            when (item.itemId) {

                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.event -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, EventFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.manage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, ManageFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.setting -> {
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
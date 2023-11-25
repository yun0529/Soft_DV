package com.gnu.softdv.src

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseActivity
import com.gnu.softdv.databinding.ActivityMainBinding
import com.gnu.softdv.src.event.EventFragment
import com.gnu.softdv.src.home.HomeFragment
import com.gnu.softdv.src.manage.ManageFragment
import com.gnu.softdv.src.search.SearchFragment
import com.gnu.softdv.src.setting.SettingFragment
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val info = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("키해시는 :", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

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
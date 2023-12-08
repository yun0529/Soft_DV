package com.gnu.softdv.src.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.gnu.softdv.config.BaseActivity
import com.gnu.softdv.databinding.ActivitySplashBinding
import com.gnu.softdv.src.MainActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) { // 액티비티 실행과 동시에 호출되는 생명주기
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)

    }
}
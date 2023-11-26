package com.gnu.softdv.config

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

// 모든 액티비티가 상속할 BaseActivity 바인딩, 토스트메시지 등의 공통 부분을 작성한다.
abstract class BaseActivity<Bg : ViewBinding>(private val inflate : (LayoutInflater) -> Bg) : AppCompatActivity(){

    // binding을 위한 변수
    protected lateinit var binding : Bg

    override fun onCreate(savedInstanceState: Bundle?) { // 액티비티 실행과 동시에 호출되는 생명주기
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater) // 해당하는 레이아웃을 binding 변수에 묶어줌
        setContentView(binding.root) // 레이아웃 화면에 출력
    }

    fun showCustomToast(message: String) { // 화면에 토스트 메시지를 작성하는 함수
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
package com.gnu.softdv.config

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

// 모든 프래그먼트가 상속할 BaseFragment 바인딩, 토스트메시지 등의 공통 부분을 작성한다.
abstract class BaseFragment<Bg : ViewBinding>(private val bind : (View) -> Bg, @LayoutRes layoutResId: Int) : Fragment(layoutResId) {

    private var fbinding : Bg? = null
    //뷰 결합
    protected val binding get() = fbinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? { // 프래그먼트 실행과 동시에 호출되는 생명주기
        fbinding = bind(super.onCreateView(inflater, container, savedInstanceState)!!)
        return binding.root
    }

    override fun onDestroyView() { // 프래그먼트 종료 동시에 호출되는 생명주기
        fbinding = null // 바인딩 초기화
        super.onDestroyView()
    }

    fun showCustomToast(message: String) { // 화면에 토스트 메시지를 작성하는 함수
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}
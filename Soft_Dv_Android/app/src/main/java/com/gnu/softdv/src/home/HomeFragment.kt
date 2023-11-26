package com.gnu.softdv.src.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentHomeBinding
import com.gnu.softdv.src.main.BannerAdapter
import com.gnu.softdv.src.main.model.banner

// 메인 화면을 출력하는 프래그먼트
class HomeFragment  : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::bind, R.layout.fragment_home
) { // 프래그먼트 실행과 동시에 호출되는 생명주기
    private var bannerSet = arrayListOf<banner>()
    private lateinit var imageAdapter : ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageAdapter = binding.vpBanner // 베너를 담을 어뎁터
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))

        Log.d("test",bannerSet.size.toString())
        imageAdapter.adapter = BannerAdapter(requireContext(),bannerSet) // 어뎁터 정의
        imageAdapter.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 뷰페이저의 넘기는 형태 정의
        binding.dotsIndicator.attachTo(binding.vpBanner) // 인디케이터를 뷰페이저 연결
    }
}
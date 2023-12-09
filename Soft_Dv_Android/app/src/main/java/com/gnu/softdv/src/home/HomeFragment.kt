package com.gnu.softdv.src.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.gnu.softdv.R
import com.gnu.softdv.config.ApplicationClass
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentHomeBinding
import com.gnu.softdv.src.MainActivity
import com.gnu.softdv.src.home.model.GetHomeGrowInfoRequest
import com.gnu.softdv.src.home.model.GetHomeGrowInfoResult
import com.gnu.softdv.src.main.BannerAdapter
import com.gnu.softdv.src.main.model.banner
import com.gnu.softdv.src.manage.ManageFragment
import com.gnu.softdv.src.search.SearchAdapter
import com.gnu.softdv.src.search.SearchVPAdapter

// 메인 화면을 출력하는 프래그먼트
class HomeFragment  : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::bind, R.layout.fragment_home
), HomeFragmentInterface { // 프래그먼트 실행과 동시에 호출되는 생명주기
    private var bannerSet = arrayListOf<banner>()
    private lateinit var imageAdapter : ViewPager2
    private lateinit var homeGrowInfoAdapter: HomeGrowInfoAdapter // 검색 결과를 리사이클러뷰에 출력할 어뎁터 선언

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageAdapter = binding.vpBanner // 베너를 담을 어뎁터
        bannerSet.add(banner("http://sonaxkorea.com/wp-content/uploads/2020/08/%EC%86%8C%EB%82%98%EB%A7%88%EC%BC%93_8%EC%9B%94_%EB%B2%8C%EB%A0%88%EA%BC%BC%EC%A7%9D%EB%A7%88_poster_01.jpg"))
        bannerSet.add(banner("https://i.ytimg.com/vi/Yn6TfmHU_Hg/maxresdefault.jpg"))
        bannerSet.add(banner("https://cdn.taglive.net/moa_img/47dfe8c1d084edc4f8656af812da2a62_1550128129_6534.jpg"))
        bannerSet.add(banner("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_9ln8tLqt-WNlEVevN85HJUVYghZErcGMlw&usqp=CAU"))
        bannerSet.add(banner("https://cdn.khgames.co.kr/news/photo/images/imglib19/100805_11_1.jpg"))

        Log.d("test",bannerSet.size.toString())
        imageAdapter.adapter = BannerAdapter(requireContext(),bannerSet) // 어뎁터 정의
        imageAdapter.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 뷰페이저의 넘기는 형태 정의
        binding.dotsIndicator.attachTo(binding.vpBanner) // 인디케이터를 뷰페이저 연결

        HomeGrowInfoService(this).tryGetHomeGrowInfo()
        Glide.with(context as MainActivity).load("https://firebasestorage.googleapis.com/v0/b/softdev-739f7.appspot.com/o/%ED%99%8D%EB%8B%A4%EB%A6%AC%EC%82%AC%EC%8A%B4%EB%B2%8C%EB%A0%88.webp?alt=media&token=d202073c-51f6-433d-93e8-bfc722349204").into(binding.ivManage)
        binding.cvManage.setOnClickListener {

            (context as MainActivity).supportFragmentManager.beginTransaction() // 생성한 다음 프래그먼트 객체를 띄움
                .add(R.id.main_frm, ManageFragment())
                .commit()
        }


    }

    override fun onGetHomeGrowInfoSuccess(response: GetHomeGrowInfoRequest) {
        if(response.isSuccess){
            homeGrowInfoAdapter = HomeGrowInfoAdapter(context as MainActivity, response.result,0)
            binding.rvComp.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.rvComp.adapter = homeGrowInfoAdapter // 어뎁터 연결
        }

    }

    override fun onGetHomeGrowInfoFailure(message: String) {
        showCustomToast(message)
    }
}
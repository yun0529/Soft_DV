package com.gnu.softdv.src.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.viewpager2.widget.ViewPager2
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentGrowInfoBinding
import com.gnu.softdv.databinding.FragmentHomeBinding
import com.gnu.softdv.src.main.BannerAdapter
import com.gnu.softdv.src.main.model.banner

class GrowInfoFragment  : BaseFragment<FragmentGrowInfoBinding>(
    FragmentGrowInfoBinding::bind, R.layout.fragment_grow_info
) {
    private var imageSet = arrayListOf<banner>()
    private lateinit var vpAdapter : ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vpAdapter = binding.vpImage
        imageSet.add(banner("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg"))
        imageSet.add(banner("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg"))
        imageSet.add(banner("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg"))
        imageSet.add(banner("https://images.chosun.com/resizer/RoEpqg90GYIOr0f6ySbZRaN9p88=/464x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JVOFO2IL6TGPZCHVVPTFXW6OOU.jpg"))

        vpAdapter.adapter = BannerAdapter(requireContext(),imageSet)
        vpAdapter.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.dotsIndicator.setViewPager2(binding.vpImage)

        requireActivity().onBackPressedDispatcher.addCallback(object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // 뒤로 가기 시 실행
                requireActivity().supportFragmentManager.beginTransaction().remove(this@GrowInfoFragment).commit()
                //requireActivity().supportFragmentManager.popBackStack()
            }
        })

    }


}
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

class HomeFragment  : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::bind, R.layout.fragment_home
) {
    private var bannerSet = arrayListOf<banner>()
    private lateinit var imageAdapter : ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageAdapter = binding.vpBanner
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))

        Log.d("test",bannerSet.size.toString())
        imageAdapter.adapter = BannerAdapter(requireContext(),bannerSet)
        imageAdapter.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.dotsIndicator.attachTo(binding.vpBanner)
    }
}
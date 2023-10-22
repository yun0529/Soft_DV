package com.gnu.softdv.src.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.viewpager2.widget.ViewPager2
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentGrowInfoBinding
import com.gnu.softdv.src.home.model.GrowInfoResponse
import com.gnu.softdv.src.main.BannerAdapter
import com.gnu.softdv.src.main.model.banner
import net.daum.android.map.MapView
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint


class GrowInfoFragment  : BaseFragment<FragmentGrowInfoBinding>(
    FragmentGrowInfoBinding::bind, R.layout.fragment_grow_info
), GrowInfoFragmentInterface {
    private var imageSet = arrayListOf<banner>()
    private lateinit var vpAdapter : ViewPager2
    private lateinit var mapView : MapView

    @SuppressLint("ClickableViewAccessibility")
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

        mapView = binding.map
        val marker = MapPOIItem()
        marker.apply {
            itemName = "서식지"   // 마커 이름
            mapPoint = MapPoint.mapPointWithGeoCoord(37.5666805, 126.9784147)   // 좌표
            markerType = MapPOIItem.MarkerType.RedPin          // 마커 모양 (커스텀)
            //customImageResourceId = R.drawable.이미지               // 커스텀 마커 이미지
            //selectedMarkerType = MapPOIItem.MarkerType.CustomImage  // 클릭 시 마커 모양 (커스텀)
            //customSelectedImageResourceId = R.drawable.이미지       // 클릭 시 커스텀 마커 이미지
            selectedMarkerType = MapPOIItem.MarkerType.BluePin          // 마커 모양
            //isCustomImageAutoscale = false      // 커스텀 마커 이미지 크기 자동 조정
            //setCustomImageAnchor(0.5f, 1.0f)    // 마커 이미지 기준점
        }
        (mapView as net.daum.mf.map.api.MapView).addPOIItem(marker)

        mapView.setOnTouchListener { view, motionEvent ->
            val action = motionEvent.action
            when (action) {
                MotionEvent.ACTION_DOWN -> binding.scroll.requestDisallowInterceptTouchEvent(true)
                MotionEvent.ACTION_UP -> binding.scroll.requestDisallowInterceptTouchEvent(true)
                MotionEvent.ACTION_MOVE -> binding.scroll.requestDisallowInterceptTouchEvent(true)
            }
            false
        }

    }

    override fun onGetGrowInfoSuccess(response: GrowInfoResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetGrowInfoFailure(message: String) {
        TODO("Not yet implemented")
    }


}
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

// 사육 정보를 담을 프래그먼트
class GrowInfoFragment  : BaseFragment<FragmentGrowInfoBinding>(
    FragmentGrowInfoBinding::bind, R.layout.fragment_grow_info
), GrowInfoFragmentInterface {
    private var imageSet = arrayListOf<banner>()
    private lateinit var vpAdapter : ViewPager2
    private lateinit var mapView : MapView
    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // 프래그먼트 실행과 동시에 호출되는 생명주기
        super.onViewCreated(view, savedInstanceState)
        //Log.d("bundle", arguments?.getInt("idx").toString())

        // 사육 정보 API 호출
        arguments?.let { GrowInfoService(this@GrowInfoFragment).tryGetGrowInfo(it.getInt("idx",0)) }

        requireActivity().onBackPressedDispatcher.addCallback(object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // 뒤로 가기 시 실행
                requireActivity().supportFragmentManager.beginTransaction().remove(this@GrowInfoFragment).commit()
                //requireActivity().supportFragmentManager.popBackStack()
            }
        })

    }

    // 사육정보 호출 응답을 성공적으로 받은 경우 해당 정보를 화면에 출력
    override fun onGetGrowInfoSuccess(response: GrowInfoResponse) {
        imageSet.add(banner(response.result.image))

        vpAdapter = binding.vpImage
        vpAdapter.adapter = BannerAdapter(requireContext(),imageSet)
        vpAdapter.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.dotsIndicator.attachTo(binding.vpImage)
        binding.name.text = response.result.kind
        binding.tvIntroContent.visibility = View.GONE
        binding.tvShapeContent.visibility = View.GONE

        binding.tvTipContent.text = response.result.breedTip
        binding.included.tvName.text = response.result.scientificName
        binding.included.tvSpecies.text = response.result.kind
        binding.included.tvLifeSpan.text = response.result.lifeCycle
        binding.included.tvMax.text = response.result.sizeMax.toString()
        binding.included.tvLifeSpan.text

        val lat = response.result.location.split(",")[0].toDouble()
        val lon = response.result.location.split(",")[1].toDouble()

        mapView = binding.map

        val marker = MapPOIItem() // 지도에 표시할 마커
        marker.apply {
            itemName = "서식지"   // 마커 이름
            mapPoint = MapPoint.mapPointWithGeoCoord(lat, lon)   // 좌표
            markerType = MapPOIItem.MarkerType.RedPin          // 마커 모양 (커스텀)
            //customImageResourceId = R.drawable.이미지               // 커스텀 마커 이미지
            //selectedMarkerType = MapPOIItem.MarkerType.CustomImage  // 클릭 시 마커 모양 (커스텀)
            //customSelectedImageResourceId = R.drawable.이미지       // 클릭 시 커스텀 마커 이미지
            selectedMarkerType = MapPOIItem.MarkerType.BluePin          // 마커 모양
            isMoveToCenterOnSelect = true
            //isCustomImageAutoscale = false      // 커스텀 마커 이미지 크기 자동 조정
            //setCustomImageAnchor(0.5f, 1.0f)    // 마커 이미지 기준점
        }
        val mapPoint = MapPoint.mapPointWithGeoCoord(lat, lon)

        //지도의 중심점을 수원 화성으로 설정, 확대 레벨 설정 (값이 작을수록 더 확대됨)
        (mapView as net.daum.mf.map.api.MapView).setMapCenterPoint(mapPoint, true)
        (mapView as net.daum.mf.map.api.MapView).setZoomLevel(7, true)
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

    override fun onGetGrowInfoFailure(message: String) {  // 사육정보 호출 응답을 받지 못한 경우
        showCustomToast(message) // 에러 메시지 출력
    }


}
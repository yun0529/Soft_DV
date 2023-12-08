package com.gnu.softdv.src.manage

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.bumptech.glide.Glide
import com.gnu.softdv.R
import com.gnu.softdv.config.BaseFragment
import com.gnu.softdv.databinding.FragmentManageBinding
import com.gnu.softdv.src.manage.model.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ManageFragment  : BaseFragment<FragmentManageBinding>(
    FragmentManageBinding::bind, R.layout.fragment_manage
), ManageFragmentInterface { // 프래그먼트 실행과 동시에 호출되는 생명주기
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val manageService = ManageService(this)
        manageService.tryGetManage(1);
        GlobalScope.launch {
            while(true){
                manageService.tryGetEnv()
                delay(10000L)
                println("test")
            }

        }

        //ManageService(this).tryGetEnv()

        binding.ivTempUp.setOnClickListener {
            val changeTemp = binding.tvEditTemp.text.toString().toFloat() + 1
            val curHumid = binding.tvCurHumid.text.toString().toFloat()
            ManageService(this).tryPatchEnv(PatchEnvRequest(1, changeTemp, curHumid))
        }
        binding.ivTempDown.setOnClickListener {
            val changeTemp = binding.tvEditTemp.text.toString().toFloat() - 1
            val curHumid = binding.tvCurHumid.text.toString().toFloat()
            ManageService(this).tryPatchEnv(PatchEnvRequest(1, changeTemp, curHumid))
        }
        binding.ivHumidUp.setOnClickListener {
            val curTemp = binding.tvCurTemp.text.toString().toFloat()
            val changeHumid = binding.tvEditHumid.text.toString().toFloat() + 1
            ManageService(this).tryPatchEnv(PatchEnvRequest(1, curTemp, changeHumid))
        }
        binding.ivHumidDown.setOnClickListener {
            val curTemp = binding.tvCurTemp.text.toString().toFloat()
            val changeHumid = binding.tvEditHumid.text.toString().toFloat() - 1
            ManageService(this).tryPatchEnv(PatchEnvRequest(1, curTemp, changeHumid))
        }

        requireActivity().onBackPressedDispatcher.addCallback(object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // 뒤로 가기 시 실행
                requireActivity().supportFragmentManager.beginTransaction().remove(this@ManageFragment).commit()
                //requireActivity().supportFragmentManager.popBackStack()
            }
        })
    }

    override fun onGetMeasureCurSuccess(response: CurEnvResult) {
        if(response.isSuccess){
            binding.tvCurTemp.text = response.result.curTemperature.toString()
            binding.tvCurHumid.text = response.result.curMoisture.toString()

            binding.tvEditTemp.text = response.result.setTemperature.toString()
            binding.tvEditHumid.text = response.result.setMoisture.toString()

//            binding.tvEditTemp.text = response.result.setTemperature.toString()
//            binding.tvEditHumid.text = response.result.setMoisture.toString()

        }else{
            showCustomToast(response.message.toString())
        }

    }

    override fun onGetMeasureCurFailure(message: String) {
        showCustomToast(message)
    }

    override fun onPatchEnvSuccess(response: PatchEnvResponse) {
        if(response.isSuccess){
            binding.tvEditTemp.text = response.result.temperature.toString()
            binding.tvEditHumid.text = response.result.humidity.toString()
        }
    }

    override fun onPatchEnvFailure(message: String) {
        showCustomToast(message)
    }

    override fun onGetManagerSuccess(response: GetManageResponse) {
        if(response.isSuccess){
            val family = response.result.size // 세대수 확인

            if(response.result[0].family == 1){ // 1세대의 사진을 대표 이미지로 지정
                Glide.with(this).load(response.result[0].image).into(binding.titleImage)
            }else{
                Glide.with(this).load(response.result[1].image).into(binding.titleImage)

            }
            binding.tvName.text = response.result[0].kind.toString() + " / " + family.toString() + "세대"
            if(response.result[0].weight == -1f){
                binding.tvFirstSize.text = response.result[0].size.toString() + "mm"
            }else if(response.result[0].size == -1f){
                binding.tvFirstSize.text = response.result[1].size.toString()+"mm"
                binding.tvSecondSize.visibility = View.GONE
                binding.tvSecond.visibility = View.GONE
                binding.tvSecondWeight.text = response.result[0].weight.toString() + "g"
            }

        }
    }

    override fun onGetManagerFailure(message: String) {
        showCustomToast(message)
    }

}
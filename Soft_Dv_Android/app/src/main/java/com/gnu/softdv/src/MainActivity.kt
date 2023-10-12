package com.gnu.softdv.src

import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.gnu.softdv.config.BaseActivity
import com.gnu.softdv.databinding.ActivityMainBinding
import com.gnu.softdv.src.main.BannerAdapter
import com.gnu.softdv.src.main.model.banner
import okhttp3.internal.notifyAll

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private var bannerSet = arrayListOf<banner>()
    private lateinit var vpAdapter :ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vpAdapter = binding.vpBanner
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))
        bannerSet.add(banner("https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"))

        Log.d("test",bannerSet.size.toString())
        vpAdapter.adapter = BannerAdapter(this,bannerSet)
        vpAdapter.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

}
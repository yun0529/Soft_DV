package com.gnu.softdv.src.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gnu.softdv.databinding.ItemMainBannerBinding
import com.gnu.softdv.src.main.model.banner

private lateinit var binding: ItemMainBannerBinding // 베너의 형태를 담고 있는 아이템 레이아웃 변수

class BannerAdapter(private val context: Context, private val dataSet: ArrayList<banner>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() { // 리사이클러뷰 라이브러리의 어뎁터 클래스를 상속

    private val TYPE_ITEM = 1;

    @NonNull // Null 허용하지 않음
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder { // 뷰를 출력
        binding = ItemMainBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) { // 데이터를 뷰에 출력
        when(holder){
            is ViewHolder -> holder.bind(dataSet[position])
        }

    }
    override fun getItemViewType(position: Int): Int { // 뷰의 형식을 반환
        return TYPE_ITEM
    }
    override fun getItemCount(): Int = dataSet.size // 포함된 뷰의 개수를 반환

    inner class ViewHolder(private val binding : ItemMainBannerBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data : banner) { // 아이템 레이아웃과 출력해야 하는 데이터를 연결시키는 메소드
            //binding.bannerImage.setImageResource(R.drawable.ic_launcher_background)
            Glide.with(context).load(data.img).into(binding.bannerImage) // 이미지를 뷰에 출력
        }
    }
}
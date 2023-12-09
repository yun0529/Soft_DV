package com.gnu.softdv.src.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gnu.softdv.R
import com.gnu.softdv.databinding.ItemMainInfosBinding
import com.gnu.softdv.databinding.ItemSearchResultBinding
import com.gnu.softdv.src.MainActivity
import com.gnu.softdv.src.home.GrowInfoFragment
import com.gnu.softdv.src.home.model.GetHomeGrowInfoResult
import com.gnu.softdv.src.search.model.SearchResult


private lateinit var binding: ItemMainInfosBinding // 하나의 아이템의 레이아웃을 바인딩

// 검색 결과를 리사이클러뷰에 엮어주는 어뎁터
class HomeGrowInfoAdapter (private val context: Context, private val dataSet: List<GetHomeGrowInfoResult>, private val count:Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM = 1; // 아이템 형태 개수

    @NonNull // Null을 허용하지 않음
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder { // 뷰를 출력
        binding = ItemMainInfosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
    override fun getItemCount(): Int { // 포함된 뷰의 개수를 반환
        return if(count == 0){
            dataSet.size
        }else{
            count
        }
    }

    inner class ViewHolder(private val binding : ItemMainInfosBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data : GetHomeGrowInfoResult) { // 아이템 레이아웃과 출력해야 하는 데이터를 연결시키는 메소드
            Glide.with(context).load(data.image).into(binding.compImage)
            binding.tv.text = data.scientificName


        }
    }
}
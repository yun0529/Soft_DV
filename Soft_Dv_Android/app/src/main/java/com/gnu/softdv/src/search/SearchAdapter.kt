package com.gnu.softdv.src.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gnu.softdv.R
import com.gnu.softdv.databinding.ItemSearchResultBinding
import com.gnu.softdv.src.MainActivity
import com.gnu.softdv.src.home.GrowInfoFragment
import com.gnu.softdv.src.search.model.SearchResult


private lateinit var binding: ItemSearchResultBinding // 하나의 아이템의 레이아웃을 바인딩

// 검색 결과를 리사이클러뷰에 엮어주는 어뎁터
class SearchAdapter (private val context: Context, private val dataSet: ArrayList<SearchResult>, private val count:Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM = 1; // 아이템 형태 개수

    @NonNull // Null을 허용하지 않음
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder { // 뷰를 출력
        binding = ItemSearchResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    inner class ViewHolder(private val binding : ItemSearchResultBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data : SearchResult) { // 아이템 레이아웃과 출력해야 하는 데이터를 연결시키는 메소드
            Glide.with(context).load(data.image).into(binding.image)
            binding.content.text = data.content
            binding.name.text = data.name

            binding.clItem.setOnClickListener { // 아이템 클릭시 발생하는 이벤트
                val bundle = Bundle() // 다음 레이아웃으로 넘길 데이터를 저장할 번들 객체를 생성
                // 번들 객체에 데이터 추가
                bundle.putInt("idx", data.idx)
                bundle.putString("image", data.image)

                val passBundleBFragment = GrowInfoFragment() // 다음 프래그먼트 객체 생성
                passBundleBFragment.arguments = bundle // 프래그먼트 객체에 번들을 담음

                (context as MainActivity).supportFragmentManager.beginTransaction() // 생성한 다음 프래그먼트 객체를 띄움
                    .add(R.id.main_frm, passBundleBFragment)
                    .commit()
            }
        }
    }
}
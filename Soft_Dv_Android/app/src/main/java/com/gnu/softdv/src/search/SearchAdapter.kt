package com.gnu.softdv.src.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gnu.softdv.R
import com.gnu.softdv.databinding.ItemSearchResultBinding
import com.gnu.softdv.src.MainActivity
import com.gnu.softdv.src.home.GrowInfoFragment
import com.gnu.softdv.src.search.model.SearchResult


private lateinit var binding: ItemSearchResultBinding

class SearchAdapter (private val context: Context, private val dataSet: ArrayList<SearchResult>, private val count:Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM = 1;

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemSearchResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolder -> holder.bind(dataSet[position])
        }

    }
    override fun getItemViewType(position: Int): Int {
        return TYPE_ITEM
    }
    override fun getItemCount(): Int {
        return if(count == 0){
            dataSet.size
        }else{
            count
        }
    }

    inner class ViewHolder(private val binding : ItemSearchResultBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data : SearchResult) {
            Glide.with(context).load(data.image).into(binding.image)
            binding.content.text = data.content
            binding.name.text = data.name

            binding.clItem.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("idx", data.idx)
                bundle.putString("image", data.image)

                val passBundleBFragment = GrowInfoFragment()
                passBundleBFragment.arguments = bundle

                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .add(R.id.main_frm, passBundleBFragment)
                    .commit()
            }
        }
    }
}
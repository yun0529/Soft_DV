package com.gnu.softdv.src.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gnu.softdv.R
import com.gnu.softdv.databinding.ItemMainBannerBinding
import com.gnu.softdv.src.main.model.banner

private lateinit var binding: ItemMainBannerBinding

class BannerAdapter(private val context: Context, private val dataSet: ArrayList<banner>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM = 1;

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemMainBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
    override fun getItemCount(): Int = dataSet.size

    inner class ViewHolder(private val binding : ItemMainBannerBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data : banner) {
            //binding.bannerImage.setImageResource(R.drawable.ic_launcher_background)
            Glide.with(context).load(data.img).into(binding.bannerImage)
        }
    }
}
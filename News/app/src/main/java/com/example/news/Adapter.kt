package com.example.news

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news.databinding.ItemNewsReBinding

class Adapter (val mItemNews : MutableList<NewsItem>) : RecyclerView.Adapter<Adapter.Holder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder { // 화면을 활성화 해주는 부분?
        val binding = ItemNewsReBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }



    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = mItemNews[position]
        holder.miamg.setImageResource(mItemNews[position].image)
        holder.mtit.text = mItemNews[position].title

    }

    override fun getItemCount(): Int { // 아이템갯수 거의 같은 형식으로 작성.
        return mItemNews.size
    }
    inner class Holder(val binding: ItemNewsReBinding) : RecyclerView.ViewHolder(binding.root) {
        val miamg = binding.itemImg
        val mtit = binding.tvItemTit

    }

}


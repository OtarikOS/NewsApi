package com.koshkin.android.newsapigoogle.presentation

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.koshkin.android.newsapigoogle.data.datanews.DataNews
import kotlinx.android.synthetic.main.item_layout.view.*

class NewsAdapter(private val context: Context,private val newsList: MutableList<DataNews>): RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    class MyViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){

        val image:ImageView =itemView.imageView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
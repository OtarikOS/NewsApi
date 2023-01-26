package com.koshkin.android.newsapigoogle.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.koshkin.android.newsapigoogle.R
import com.koshkin.android.newsapigoogle.data.datanews.DataNews
import com.bumptech.glide.Glide


class NewsAdapter(private val context: Context, private val newsList: MutableList<DataNews?>): RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    class MyViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){

        val image:ImageView =itemView.findViewById(R.id.imageView)
        val txtName:TextView =itemView.findViewById(R.id.source_name)
        val txtAuthor:TextView =itemView.findViewById(R.id.author)
        val txtTitle:TextView =itemView.findViewById(R.id.title_news)
        val txtDescription:TextView =itemView.findViewById(R.id.description)
        val txtUrl:TextView =itemView.findViewById(R.id.url)
        val txtUrlToImage:TextView =itemView.findViewById(R.id.url_toImage)
        val txtPublished:TextView =itemView.findViewById(R.id.publishedAt)
        val txtContent:TextView =itemView.findViewById(R.id.content)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = newsList?.get(position)

        Glide.with(context).load(newsList?.get(position)!!.articles?.get(position)?.urlToImage).into(holder.image)
        holder.txtName.text = newsList[position]!!.articles[position].source?.name
        holder.txtAuthor.text = newsList[position]!!.articles[position].author
        holder.txtTitle.text = newsList[position]!!.articles[position].title
        holder.txtDescription.text = newsList[position]!!.articles[position].description
        holder.txtUrl.text = newsList[position]!!.articles[position].url
        holder.txtUrlToImage.text = newsList[position]!!.articles[position].urlToImage
        holder.txtPublished.text = newsList[position]!!.articles[position].publishedAt
        holder.txtContent.text = newsList[position]!!.articles[position].content
    }

    override fun getItemCount()=newsList!!.size
}
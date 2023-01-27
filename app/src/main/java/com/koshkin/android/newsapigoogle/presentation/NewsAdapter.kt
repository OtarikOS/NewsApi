package com.koshkin.android.newsapigoogle.presentation

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.koshkin.android.newsapigoogle.R
import com.bumptech.glide.Glide
import com.koshkin.android.newsapigoogle.data.datanews.Articles


class NewsAdapter(private val context: Context, private val newsList: ArrayList<Articles>): RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    companion object{
        private  val TAG = NewsAdapter::class.java.simpleName
    }

    class MyViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){

        val image:ImageView =itemView.findViewById(R.id.imageView)
        val txtName:TextView =itemView.findViewById(R.id.source_name)
        val txtAuthor:TextView =itemView.findViewById(R.id.author)
        val txtTitle:TextView =itemView.findViewById(R.id.title_news)
        val txtDescription:TextView =itemView.findViewById(R.id.description)
        val txtUrl:TextView =itemView.findViewById(R.id.url)
        val txtUrlToImage:TextView =itemView.findViewById(R.id.url_toImage)
        val txtPublished:TextView =itemView.findViewById(R.id.publishedAt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = newsList?.get(position)

        Glide.with(context).load(newsList[position].urlToImage).into(holder.image)
        holder.txtName.text = newsList[position].source?.name
        holder.txtAuthor.text = newsList[position].author
        holder.txtTitle.text = newsList[position].title
        holder.txtDescription.text = newsList[position].description
        holder.txtUrl.text = newsList[position].url
        holder.txtUrlToImage.text = newsList[position].urlToImage
        holder.txtPublished.text = newsList[position].publishedAt
        Log.i(TAG,newsList[position].title.toString())
    }

    override fun getItemCount()=newsList!!.size

}
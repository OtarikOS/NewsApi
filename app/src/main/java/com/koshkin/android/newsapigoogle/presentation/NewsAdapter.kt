package com.koshkin.android.newsapigoogle.presentation

import android.content.Context
import android.text.Html
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import android.text.util.Linkify
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


class NewsAdapter(private val context: Context, private val newsList: ArrayList<Articles>): RecyclerView.Adapter<NewsAdapter.MyViewHolder>(){


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
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = newsList?.get(position)
        var data = "<a href = "+newsList[position].url+">"+"Источник"+"</a>"

        val textToUrl = "Источник"
      //  val ss = SpannableString(textToUrl)
     //   ss.setSpan(URLSpan(textToUrl),0,textToUrl.length,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        Glide.with(context).load(newsList[position].urlToImage).into(holder.image)
        holder.txtName.text = newsList[position].source?.name
        holder.txtAuthor.text = newsList[position].author
        holder.txtTitle.text = newsList[position].title
        holder.txtDescription.text = newsList[position].description
     //   holder.txtUrl.text = newsList[position].url
        holder.txtUrlToImage.text = newsList[position].urlToImage
        holder.txtPublished.text = newsList[position].publishedAt
        Log.i("DIRR",newsList[position].url.toString())

       // holder.txtUrl.linksClickable
    //    holder.txtUrl.text = data
     //   holder.txtUrl.text =ss
     //   Linkify.addLinks(holder.txtUrl,Linkify.WEB_URLS)

        holder.txtUrl.text =(Html.fromHtml(data,Html.FROM_HTML_MODE_COMPACT))
        holder.txtUrl.movementMethod =LinkMovementMethod.getInstance()

    }

    override fun getItemCount()=newsList!!.size



}
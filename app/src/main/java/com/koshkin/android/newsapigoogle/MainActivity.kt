package com.koshkin.android.newsapigoogle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.koshkin.android.newsapigoogle.common.Common
import com.koshkin.android.newsapigoogle.data.DataNewsApi
import com.koshkin.android.newsapigoogle.data.datanews.Articles
import com.koshkin.android.newsapigoogle.data.datanews.DataNews
import com.koshkin.android.newsapigoogle.presentation.NewsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    companion object{
        private  val TAG =MainActivity::class.java.simpleName
    }

    lateinit var mDataNewsApi: DataNewsApi
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDataNewsApi = Common.dataNewsApi
        recyclerNewsList.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerNewsList.layoutManager = linearLayoutManager

        getAllNews()
    }

    private fun getAllNews() {
        mDataNewsApi.getNews().enqueue(object : Callback<MutableList<Articles>> {
            override fun onFailure(call: Call<MutableList<Articles>>, t: Throwable) {}

            override fun onResponse(
                call: Call<MutableList<Articles>>,
                response: Response<MutableList<Articles>>

            ) {
                newsAdapter = NewsAdapter(baseContext, response.body() as MutableList<Articles>)
                newsAdapter.notifyDataSetChanged()
                recyclerNewsList.adapter = newsAdapter
            }

        }
        )
    }
}

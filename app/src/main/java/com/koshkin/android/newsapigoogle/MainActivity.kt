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
    lateinit var articlesArrayList: ArrayList<Articles>

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
        mDataNewsApi.getNews().enqueue(object : Callback<DataNews> {
            override fun onFailure(call: Call<DataNews>, t: Throwable) {}

            override fun onResponse(
                call: Call<DataNews>,
                response: Response<DataNews>

            ) {
                newsAdapter = NewsAdapter(baseContext, response.body()?.articles as ArrayList<Articles>)
                newsAdapter.notifyDataSetChanged()
                recyclerNewsList.adapter = newsAdapter
            }

        }
        )
    }
}

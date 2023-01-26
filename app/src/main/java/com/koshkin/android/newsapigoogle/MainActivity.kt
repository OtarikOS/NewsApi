package com.koshkin.android.newsapigoogle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.koshkin.android.newsapigoogle.common.Common
import com.koshkin.android.newsapigoogle.data.DataNewsApi
import com.koshkin.android.newsapigoogle.data.datanews.DataNews
import com.koshkin.android.newsapigoogle.presentation.NewsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

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
        mDataNewsApi.getNews().enqueue(object : Callback<MutableList<DataNews?>> {
            override fun onFailure(call: Call<MutableList<DataNews?>>, t: Throwable) {}

            override fun onResponse(
                call: Call<MutableList<DataNews?>>,
                response: Response<MutableList<DataNews?>>
            ) {
                newsAdapter = NewsAdapter(baseContext, response.body() as MutableList<DataNews?>)
                newsAdapter.notifyDataSetChanged()
                recyclerNewsList.adapter = newsAdapter
            }

        }
        )
    }
}

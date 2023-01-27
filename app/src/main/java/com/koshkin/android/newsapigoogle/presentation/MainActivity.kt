package com.koshkin.android.newsapigoogle.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.koshkin.android.newsapigoogle.R
import com.koshkin.android.newsapigoogle.common.Common
import com.koshkin.android.newsapigoogle.data.DataNewsApi
import com.koshkin.android.newsapigoogle.data.datanews.Articles
import com.koshkin.android.newsapigoogle.data.datanews.DataNews
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mDataNewsApi: DataNewsApi
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var newsAdapter: NewsAdapter
    lateinit var swipe: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDataNewsApi = Common.dataNewsApi
        recyclerNewsList.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerNewsList.layoutManager = linearLayoutManager

        val progressBar: ProgressBar =findViewById(R.id.progressBar)
        getAllNews()

        swipe = findViewById(R.id.swipe)
        swipe.setOnRefreshListener {
            swipe.isRefreshing = false
            getAllNews()}
    }

    private fun getAllNews() {
        mDataNewsApi.getNews().enqueue(object : Callback<DataNews> {
            override fun onFailure(call: Call<DataNews>, t: Throwable) {
                progressBar.visibility = View.GONE
                Toast.makeText(this@MainActivity,"Ошибка соединения "+t,Toast.LENGTH_LONG).show()
                Log.i("RER","$t")
            }

            override fun onResponse(
                call: Call<DataNews>,
                response: Response<DataNews>

            ) {
                progressBar.visibility = View.GONE
                newsAdapter = NewsAdapter(baseContext, response.body()?.articles as ArrayList<Articles>)
                newsAdapter.notifyDataSetChanged()
                recyclerNewsList.adapter = newsAdapter
            }

        }
        )
    }
}

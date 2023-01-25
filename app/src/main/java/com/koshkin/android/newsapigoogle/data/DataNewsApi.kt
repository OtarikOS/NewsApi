package com.koshkin.android.newsapigoogle.data

import com.koshkin.android.newsapigoogle.data.datanews.DataNews
import retrofit2.Call
import retrofit2.http.GET

interface DataNewsApi {
    @GET("/top-headlines?country=ru&apiKey=1f740efa1d0747d9a12fa555fde103e3")
    fun getNews(): Call<DataNews>
}
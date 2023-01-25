package com.koshkin.android.newsapigoogle.common

import com.koshkin.android.newsapigoogle.data.DataNewsApi
import com.koshkin.android.newsapigoogle.data.RetrofitClient
import retrofit2.create

object Common {
    private val BASE_URL = "https://newsapi.org/v2/"
    val dataNewsApi: DataNewsApi
    get()= RetrofitClient.getClient(BASE_URL)!!.create(DataNewsApi::class.java)

}
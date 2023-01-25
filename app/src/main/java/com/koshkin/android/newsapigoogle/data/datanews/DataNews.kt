package com.koshkin.android.newsapigoogle.data.datanews

import com.google.gson.annotations.SerializedName

data class DataNews(@SerializedName("status"       ) var status       : String?             = null,
                    @SerializedName("totalResults" ) var totalResults : Int?                = null,
                    @SerializedName("articles"     ) var articles     : ArrayList<Articles> = arrayListOf())

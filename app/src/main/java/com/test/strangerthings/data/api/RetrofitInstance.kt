package com.test.strangerthings.data.api

import com.test.strangerthings.util.Constant.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: QuotesApi by lazy {
        retrofit.create(QuotesApi::class.java)
    }
}
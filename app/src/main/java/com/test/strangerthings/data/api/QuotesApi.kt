package com.test.strangerthings.data.api

import com.test.strangerthings.data.model.QuotesItem
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {

    @GET("api/quotes/500")
    suspend fun getQuotes(): Response<List<QuotesItem>>


}
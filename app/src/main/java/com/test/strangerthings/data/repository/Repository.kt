package com.test.strangerthings.data.repository

import com.test.strangerthings.data.api.RetrofitInstance
import com.test.strangerthings.data.model.QuotesItem
import retrofit2.Response

class Repository {

    suspend fun getQuotes(): Response<List<QuotesItem>> {
        return RetrofitInstance.api.getQuotes()
    }
}
package com.test.strangerthings.data.model

import java.io.Serializable

data class QuotesItem(
    val author: String,
    val quote: String
) : Serializable
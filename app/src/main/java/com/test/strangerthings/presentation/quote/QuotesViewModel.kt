package com.test.strangerthings.presentation.quote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.strangerthings.data.model.QuotesItem
import com.test.strangerthings.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class QuotesViewModel(private val repository: Repository) : ViewModel() {
    val myResponse: MutableLiveData<Response<List<QuotesItem>>> = MutableLiveData()

    init {
        getQuotes()
    }
    fun getQuotes() {
        viewModelScope.launch {
            try {
                val response: Response<List<QuotesItem>> = repository.getQuotes()
                myResponse.value = response
            } catch (e: Exception) {
                Log.d("Error", e.toString())
            }
        }
    }
}
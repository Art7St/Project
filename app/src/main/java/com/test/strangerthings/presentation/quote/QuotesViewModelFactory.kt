package com.test.strangerthings.presentation.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.strangerthings.data.repository.Repository

class QuotesViewModelFactory() : ViewModelProvider.Factory {

    private val repository = Repository()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesViewModel(repository) as T
    }
}
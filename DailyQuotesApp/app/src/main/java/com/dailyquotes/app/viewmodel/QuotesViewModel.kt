package com.dailyquotes.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dailyquotes.app.model.Quote
import com.dailyquotes.app.repository.QuotesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class QuotesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = QuotesRepository(application)
    
    val quotes: List<Quote> = repository.getAllQuotes()
    val likedQuoteIds: StateFlow<Set<String>> = repository.likedQuoteIds
        .stateIn(viewModelScope, SharingStarted.Lazily, emptySet())

    fun toggleLike(quoteId: String) {
        repository.toggleLike(quoteId)
    }
}

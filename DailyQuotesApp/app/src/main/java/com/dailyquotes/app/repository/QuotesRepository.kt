package com.dailyquotes.app.repository

import android.content.Context
import android.content.SharedPreferences
import com.dailyquotes.app.data.QuotesDataSource
import com.dailyquotes.app.model.Quote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuotesRepository(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("quotes_prefs", Context.MODE_PRIVATE)
    private val LIKED_QUOTES_KEY = "liked_quotes"

    private val _likedQuoteIds = MutableStateFlow<Set<String>>(getLikedIdsFromPrefs())
    val likedQuoteIds: StateFlow<Set<String>> = _likedQuoteIds.asStateFlow()

    fun getAllQuotes(): List<Quote> {
        return QuotesDataSource.quotes
    }

    fun toggleLike(quoteId: String) {
        val currentLikes = _likedQuoteIds.value.toMutableSet()
        if (currentLikes.contains(quoteId)) {
            currentLikes.remove(quoteId)
        } else {
            currentLikes.add(quoteId)
        }
        _likedQuoteIds.value = currentLikes
        saveLikedIdsToPrefs(currentLikes)
    }

    fun isLiked(quoteId: String): Boolean {
        return _likedQuoteIds.value.contains(quoteId)
    }

    private fun getLikedIdsFromPrefs(): Set<String> {
        return prefs.getStringSet(LIKED_QUOTES_KEY, emptySet()) ?: emptySet()
    }

    private fun saveLikedIdsToPrefs(ids: Set<String>) {
        prefs.edit().putStringSet(LIKED_QUOTES_KEY, ids).apply()
    }
}

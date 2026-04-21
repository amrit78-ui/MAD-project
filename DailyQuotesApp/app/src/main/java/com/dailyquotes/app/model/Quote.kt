package com.dailyquotes.app.model

data class Quote(
    val id: String,
    val text: String,
    val author: String,
    val imageUrl: String? = null
)

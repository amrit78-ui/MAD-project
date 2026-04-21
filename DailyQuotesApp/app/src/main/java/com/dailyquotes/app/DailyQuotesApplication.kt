package com.dailyquotes.app

import android.app.Application

class DailyQuotesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Firebase.initialize(this) will be handled mostly implicitly if google-services.json is present
    }
}

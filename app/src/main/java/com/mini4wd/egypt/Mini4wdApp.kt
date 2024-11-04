package com.mini4wd.egypt

import android.app.Application
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Mini4wdApp :Application() {
  override fun onCreate() {
    super.onCreate()

  }
}
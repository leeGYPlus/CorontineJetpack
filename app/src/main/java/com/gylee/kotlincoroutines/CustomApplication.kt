package com.gylee.kotlincoroutines

import android.app.Application
import android.content.Context
import android.os.Debug

class CustomApplication:Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }
}
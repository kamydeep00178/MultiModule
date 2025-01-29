package com.lock.multimoduleproject

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication

class MyApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }
}
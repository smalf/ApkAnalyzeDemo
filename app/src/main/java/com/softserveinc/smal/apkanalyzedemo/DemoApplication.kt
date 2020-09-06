package com.softserveinc.smal.apkanalyzedemo

import android.app.Application

class DemoApplication: Application() {
    lateinit var adManager: AdManager
    private set

    override fun onCreate() {
        super.onCreate()

        adManager = AdManager(this, listOf(nativeBannerAdID()))
        adManager.init()
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private external fun nativeBannerAdID(): String

    companion object {
        // Used to load the 'native-key-store-lib' library on application startup.
        init {
            System.loadLibrary("native-key-store-lib")
        }
    }
}
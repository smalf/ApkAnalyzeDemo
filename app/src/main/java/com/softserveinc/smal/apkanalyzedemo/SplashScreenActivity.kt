package com.softserveinc.smal.apkanalyzedemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreenActivity : Activity() {

    private val uiHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        uiHandler.postDelayed({
            launchMainScreen()
        }, 3000)
    }

    private fun launchMainScreen() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
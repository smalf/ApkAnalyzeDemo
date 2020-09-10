package com.softserveinc.smal.apkanalyzedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.gms.ads.AdView

class MainActivity : AppCompatActivity() {
    private lateinit var adView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.token_label1).text = SECRET_TOKEN
        findViewById<TextView>(R.id.token_label2).text = BuildConfig.SECRET_TOKEN

        val nativeKey = nativeSecretToken()
        val nativeKey2 = nativeKey

        findViewById<TextView>(R.id.token_label3).text = nativeKey2
        findViewById<TextView>(R.id.token_label4).text = getString(R.string.test_api_key)

        initAds()
    }

    override fun onPause() {
        adView.pause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        adView.resume()
    }

    override fun onDestroy() {
        adView.destroy()
        super.onDestroy()
    }

    private fun initAds() {
        adView = findViewById(R.id.ad_view) //line: 43
        (applicationContext as DemoApplication).adManager.apply { //line: 44
            triggerAdLoading(adView) //line: 45
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private external fun nativeSecretToken(): String

    companion object {
        const val SECRET_TOKEN = "const_secret_token"

        // Used to load the 'native-key-store-lib' library on application startup.
        init {
            System.loadLibrary("native-key-store-lib")
        }
    }
}
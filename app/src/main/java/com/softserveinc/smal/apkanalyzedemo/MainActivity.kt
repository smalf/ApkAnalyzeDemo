package com.softserveinc.smal.apkanalyzedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.ads.AdView

class MainActivity : AppCompatActivity() {
    private lateinit var adView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.api_btn_1).setOnClickListener {
            triggerAPICall("api v1", SECRET_TOKEN)
        }
        findViewById<Button>(R.id.api_btn_2).setOnClickListener {
            triggerAPICall("api v2", BuildConfig.SECRET_TOKEN)
        }
        findViewById<Button>(R.id.api_btn_3).setOnClickListener {
            triggerAPICall("api v3", getString(R.string.test_api_key))
        }
        findViewById<Button>(R.id.api_btn_4).setOnClickListener {
            triggerAPICall("api v4", nativeSecretToken())
        }

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

    private fun triggerAPICall(apiVersion: String, token: String) {
        Toast.makeText(this,"$apiVersion call triggered token: $token", Toast.LENGTH_SHORT).show()
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private external fun nativeSecretToken(): String

    companion object {
        private const val SECRET_TOKEN = "const_secret_token:qwerpsdflggkl480hjpoiFGHJFGsdpf103oiqwekljkldfASDF"
        private const val TAG = "MainActivity"

        // Used to load the 'native-key-store-lib' library on application startup.
        init {
            System.loadLibrary("native-key-store-lib")
        }
    }
}
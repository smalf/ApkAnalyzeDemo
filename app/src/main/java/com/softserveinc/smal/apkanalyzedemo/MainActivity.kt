package com.softserveinc.smal.apkanalyzedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val peopleRepository by lazy {
        PeopleRepository()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.token_label1).text = SECRET_TOKEN
        findViewById<TextView>(R.id.token_label2).text = BuildConfig.SECRET_TOKEN

        val nativeKey = nativeSecretToken()
        val nativeKey2 = nativeKey

        findViewById<TextView>(R.id.token_label3).text = nativeKey2


        loadData()
        loadDataWithKeystoreDebugToken()
    }

    private fun loadData() {
        peopleRepository.getPeople(SECRET_TOKEN)
    }

    private fun loadDataWithKeystoreDebugToken() {
        peopleRepository.getPeople(BuildConfig.SECRET_TOKEN)
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
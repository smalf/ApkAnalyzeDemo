package com.softserveinc.smal.apkanalyzedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private val peopleRepository by lazy {
        PeopleRepository()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
        loadDataWithKeystoreDebugToken()
    }

    private fun loadData() {
        peopleRepository.getPeople(SECRET_TOKEN)
    }

    private fun loadDataWithKeystoreDebugToken() {
        peopleRepository.getPeople(BuildConfig.SECRET_TOKEN)
    }

    companion object {
        const val SECRET_TOKEN = "jb&1a=U51-ng2="
    }
}
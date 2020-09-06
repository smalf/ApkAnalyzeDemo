package com.softserveinc.smal.apkanalyzedemo

import android.content.Context
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration

class AdManager(private val context: Context, private val bannerIds: List<String>) {

    fun init() {
        // Initialize the Mobile Ads SDK with an AdMob App ID.
        MobileAds.initialize(context) {}

        // Set your test devices. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(bannerIds)
                .build()
        )
    }

    fun triggerAdLoading(adView: AdView) {
        adView.loadAd(AdRequest.Builder().build())
    }
}
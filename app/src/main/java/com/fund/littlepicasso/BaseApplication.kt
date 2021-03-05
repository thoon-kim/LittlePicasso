package com.fund.littlepicasso

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        // Kakao SDK 초기화
        KakaoSdk.init(this@BaseApplication, getString(R.string.kakao_app_key))
    }

}
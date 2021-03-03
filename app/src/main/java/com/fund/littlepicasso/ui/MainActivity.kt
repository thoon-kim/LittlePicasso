package com.fund.littlepicasso.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fund.littlepicasso.R
import com.fund.littlepicasso.ui.login.GoogleLoginActivity
import com.fund.littlepicasso.ui.login.InstaLoginActivity
import com.fund.littlepicasso.ui.login.KakaoLoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun kakaoLogin(view: View) {
        val kakaoLoginIntent = Intent(this, KakaoLoginActivity::class.java)
        startActivity(kakaoLoginIntent)
    }

    fun googleLogin(view: View) {
        val googleLoginIntent = Intent(this, GoogleLoginActivity::class.java)
        startActivity(googleLoginIntent)
    }

    fun instaLogin(view: View) {
        val instaLoginIntent = Intent(this, InstaLoginActivity::class.java)
        startActivity(instaLoginIntent)
    }


}
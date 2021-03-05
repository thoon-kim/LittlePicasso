package com.fund.littlepicasso.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.fund.littlepicasso.R
import kotlinx.android.synthetic.main.activity_insta_login.*


class InstaLoginActivity: AppCompatActivity() {

    lateinit var callbackManager: CallbackManager
    var redirectUrl = "https://socialsizzle.herokuapp.com/auth/" // TODO redirect url 수정
    var url = "https://api.instagram.com/oauth/authorize" +
            "?client_id=857265938463278" +
            "&redirect_uri=$redirectUrl" +
            "&scope=user_profile" +
            "&response_type=code"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta_login)

        var mWebClient = WebClient()
        web_view.loadUrl(url)
        web_view.webViewClient = mWebClient
        web_view.settings.javaScriptEnabled = true

//        login_button.setReadPermissions("email")
//
//        callbackManager = CallbackManager.Factory.create()
//
//        // Callback registration
//        login_button.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
//            override fun onSuccess(loginResult: LoginResult?) {
//                // App code
//            }
//
//            override fun onCancel() {
//                // App code
//            }
//
//            override fun onError(exception: FacebookException) {
//                // App code
//            }
//        })
//
//        LoginManager.getInstance().registerCallback(callbackManager,
//            object : FacebookCallback<LoginResult?> {
//                override fun onSuccess(loginResult: LoginResult?) {
//                    // App code
//                    var accessToken: AccessToken = AccessToken.getCurrentAccessToken()
//                    var isLoggedIn: Boolean = accessToken != null && !accessToken.isExpired
//                }
//
//                override fun onCancel() {
//                    // App code
//                }
//
//                override fun onError(exception: FacebookException) {
//                    // App code
//                }
//            })
    }

    class WebClient: WebViewClient() {

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            if (request != null) {
                Log.d("InstagramTest", "url : " + request.url)
                // TODO redirect 처리 후 앱 동작 처리
            }
            return super.shouldOverrideUrlLoading(view, request)
        }

    }

}
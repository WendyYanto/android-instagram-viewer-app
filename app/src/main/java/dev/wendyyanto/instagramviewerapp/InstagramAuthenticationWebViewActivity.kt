package dev.wendyyanto.instagramviewerapp

import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


/**
 * Created by wendy.yanto on 12/29/2021
 */

class InstagramAuthenticationWebViewActivity: AppCompatActivity() {

    companion object {
        private const val CLIENT_ID = ""
        private const val SECRET_ID = ""
        private const val REDIRECT_URI = "https://wendyyanto.github.io/load"
    }

    private lateinit var webview: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instagram_authentication_webview)

        webview = findViewById(R.id.wv_instagram)

        webview.loadUrl("https://api.instagram.com/oauth/authorize?client_id=$CLIENT_ID&client_secret=$SECRET_ID&redirect_uri=$REDIRECT_URI&scope=user_profile,user_media&response_type=code")
        webview.settings.javaScriptEnabled = true
        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                Log.v("WEND_IG", url.toString())
                return super.shouldOverrideUrlLoading(view, url)
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                Log.v("WEND_IG", request?.url.toString())
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
    }
}
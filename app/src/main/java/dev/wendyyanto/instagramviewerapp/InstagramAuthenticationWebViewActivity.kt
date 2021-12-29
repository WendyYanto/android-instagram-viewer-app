package dev.wendyyanto.instagramviewerapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import dev.wendyyanto.instagramviewerapp.data.local.LocalDataSource
import dev.wendyyanto.instagramviewerapp.gallery.GalleryActivity


/**
 * Created by wendy.yanto on 12/29/2021
 */

class InstagramAuthenticationWebViewActivity: AppCompatActivity() {

    companion object {
        private const val CLIENT_ID = BuildConfig.INSTAGRAM_CLIENT_ID
        private const val SECRET_ID = BuildConfig.INSTAGRAM_SECRET_ID
        private const val REDIRECT_URI = BuildConfig.INSTAGRAM_REDIRECT_URI
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
                val safeUrl = url.toString()
                if (safeUrl.startsWith(REDIRECT_URI)) {
                    saveToken(safeUrl)
                    goToGallery()
                    return true
                }

                return super.shouldOverrideUrlLoading(view, url)
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                val safeUrl = request?.url.toString()
                if (safeUrl.startsWith(REDIRECT_URI)) {
                    saveToken(safeUrl)
                    goToGallery()
                    return true
                }

                return super.shouldOverrideUrlLoading(view, request)
            }
        }
    }

    private fun saveToken(redirectUrl: String) {
        if (hasError(redirectUrl)) {
            return
        }

        val authenticationCode = getAuthenticationCode(redirectUrl)
        Log.v("WEND_I", authenticationCode)
        LocalDataSource.setAuthenticationToken(authenticationCode)
    }

    private fun hasError(redirectUrl: String): Boolean {
        return false
    }

    private fun getAuthenticationCode(redirectUrl: String): String {
        val uri = Uri.parse(redirectUrl)
        val code = uri.getQueryParameter("code")
        return code?.split("_#")?.firstOrNull().orEmpty()
    }

    private fun goToGallery() {
        val intent = Intent(this, GalleryActivity::class.java)
        startActivity(intent)
        finish()
    }
}
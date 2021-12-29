package dev.wendyyanto.instagramviewerapp.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import dev.wendyyanto.instagramviewerapp.R
import dev.wendyyanto.instagramviewerapp.gallery.GalleryActivity
import dev.wendyyanto.instagramviewerapp.instagrampermission.InstagramAuthenticationWebViewActivity

class MainActivity : AppCompatActivity() {

  private lateinit var textView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    textView = findViewById(R.id.tv_instagram_gallery)

    textView.setOnClickListener {
      if (hasInstagramAccessToken()) {
        goToGallery()
      } else {
        goToInstagramPermissionPage()
      }
    }
  }

  private fun hasInstagramAccessToken(): Boolean {
    val token = getSharedPreferences("instagram", Context.MODE_PRIVATE)
      .getString("ACCESS_TOKEN", "")
      .orEmpty()
    return token.isNotBlank()
  }

  private fun goToGallery() {
    val intent = Intent(this, GalleryActivity::class.java)
    startActivity(intent)
  }

  private fun goToInstagramPermissionPage() {
    val intent = Intent(this, InstagramAuthenticationWebViewActivity::class.java)
    startActivity(intent)
  }
}
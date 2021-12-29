package dev.wendyyanto.instagramviewerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

  private lateinit var textView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    textView = findViewById(R.id.tv_login_to_instagram)

    textView.setOnClickListener {
      goToInstagramPopupWindowWebView()
    }
  }

  private fun goToInstagramPopupWindowWebView() {
    val intent = Intent(this, InstagramAuthenticationWebViewActivity::class.java)
    startActivity(intent)
  }
}
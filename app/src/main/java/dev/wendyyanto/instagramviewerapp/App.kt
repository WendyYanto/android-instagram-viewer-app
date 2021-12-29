package dev.wendyyanto.instagramviewerapp

import android.app.Application
import com.facebook.stetho.Stetho


/**
 * Created by wendy.yanto on 12/29/2021
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}
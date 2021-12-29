package dev.wendyyanto.instagramviewerapp.data

import com.facebook.stetho.okhttp3.StethoInterceptor
import dev.wendyyanto.instagramviewerapp.data.remote.InstagramAPIService
import dev.wendyyanto.instagramviewerapp.data.remote.InstagramGraphService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by wendy.yanto on 12/29/2021
 */

object RemoteDataSource {

    fun getInstagramAPIService(): InstagramAPIService {

        return Retrofit
            .Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .baseUrl("https://api.instagram.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build())
            .build()
            .create(InstagramAPIService::class.java)
    }

    fun getInstagramGraphService(): InstagramGraphService {
        return Retrofit
            .Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .baseUrl("https://graph.instagram.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build())
            .build()
            .create(InstagramGraphService::class.java)
    }
}
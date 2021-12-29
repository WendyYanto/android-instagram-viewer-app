package dev.wendyyanto.instagramviewerapp.data.remote

import dev.wendyyanto.instagramviewerapp.data.model.response.AccessTokenResponse
import dev.wendyyanto.instagramviewerapp.data.model.response.MediaResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by wendy.yanto on 12/29/2021
 */

interface InstagramGraphService {

    @GET("/me/media")
    fun getMedias(
        @Query("access_token") accessToken: String,
        @Query("fields") fields: String
    ): Observable<Response<MediaResponse>>

    @GET("/access_token")
    fun getLongLivedAccessToken (
        @Query("access_token") accessToken: String,
        @Query("client_secret") clientSecret: String,
        @Query("grant_type") grantType: String
    ): Observable<Response<AccessTokenResponse>>
}
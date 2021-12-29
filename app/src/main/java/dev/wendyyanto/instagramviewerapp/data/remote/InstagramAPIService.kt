package dev.wendyyanto.instagramviewerapp.data.remote

import dev.wendyyanto.instagramviewerapp.data.model.response.AccessTokenResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


/**
 * Created by wendy.yanto on 12/29/2021
 */

interface InstagramAPIService {

    @POST("/oauth/access_token")
    @FormUrlEncoded
    fun getShortLivedAccessToken(
        @Field("client_id") clientId: String?,
        @Field("client_secret") clientSecret: String?,
        @Field("code") code: String?,
        @Field("grant_type") grantType: String?,
        @Field("redirect_uri") redirectUri: String?
    ): Observable<Response<AccessTokenResponse>>
}
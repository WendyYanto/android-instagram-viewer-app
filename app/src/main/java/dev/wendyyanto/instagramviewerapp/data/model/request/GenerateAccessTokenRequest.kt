package dev.wendyyanto.instagramviewerapp.data.model.request

import com.google.gson.annotations.SerializedName


/**
 * Created by wendy.yanto on 12/29/2021
 */

data class GenerateAccessTokenRequest(

    @SerializedName("client_id")
    val clientId: String? = null,

    @SerializedName("client_secret")
    val clientSecret: String? = null,

    @SerializedName("code")
    val code: String? = null,

    @SerializedName("grant_type")
    val grantType: String? = null,

    @SerializedName("redirect_uri")
    val redirectUri: String? = null
)
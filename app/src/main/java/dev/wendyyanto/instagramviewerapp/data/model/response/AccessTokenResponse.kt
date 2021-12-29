package dev.wendyyanto.instagramviewerapp.data.model.response

import com.google.gson.annotations.SerializedName


/**
 * Created by wendy.yanto on 12/29/2021
 */

data class AccessTokenResponse(

    @SerializedName("access_token")
    val accessToken: String? = null,

    @SerializedName("user_id")
    val userId: String? = null
)
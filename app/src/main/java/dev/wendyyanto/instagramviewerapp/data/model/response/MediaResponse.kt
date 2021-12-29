package dev.wendyyanto.instagramviewerapp.data.model.response

import com.google.gson.annotations.SerializedName


/**
 * Created by wendy.yanto on 12/29/2021
 */

data class MediaResponse(

    @SerializedName("data")
    val data: List<MediaItemResponse>? = null
)


data class MediaItemResponse(

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("media_type")
    val mediaType: String? = null,

    @SerializedName("media_url")
    val mediaUrl: String? = null
)
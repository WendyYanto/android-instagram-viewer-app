package dev.wendyyanto.instagramviewerapp.gallery


/**
 * Created by wendy.yanto on 12/29/2021
 */

interface GalleryView {

    fun setImages(images: List<String>)

    fun saveAccessToken(accessToken: String)
}
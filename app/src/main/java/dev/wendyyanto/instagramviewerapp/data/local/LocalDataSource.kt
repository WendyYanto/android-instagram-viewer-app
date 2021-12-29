package dev.wendyyanto.instagramviewerapp.data.local


/**
 * Created by wendy.yanto on 12/29/2021
 */

object LocalDataSource {

    private var authenticationToken: String = ""
    private var userId: String = ""
    private var accessToken: String = ""

    fun setAuthenticationToken(authenticationToken: String) {
        this.authenticationToken = authenticationToken
    }

    fun getAuthenticationToken(): String = authenticationToken

    fun setUserId(userId: String) {
        this.userId = userId
    }

    fun getUserId(): String = userId

    fun setAccessToken(accessToken: String) {
        this.accessToken = accessToken
    }

    fun getAccessToken(): String = accessToken
}
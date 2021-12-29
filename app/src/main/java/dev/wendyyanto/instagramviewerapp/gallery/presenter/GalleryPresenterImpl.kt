package dev.wendyyanto.instagramviewerapp.gallery.presenter

import dev.wendyyanto.instagramviewerapp.BuildConfig
import dev.wendyyanto.instagramviewerapp.data.local.LocalDataSource
import dev.wendyyanto.instagramviewerapp.data.model.response.AccessTokenResponse
import dev.wendyyanto.instagramviewerapp.data.model.response.MediaResponse
import dev.wendyyanto.instagramviewerapp.data.remote.InstagramAPIService
import dev.wendyyanto.instagramviewerapp.data.remote.InstagramGraphService
import dev.wendyyanto.instagramviewerapp.gallery.GalleryView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response


/**
 * Created by wendy.yanto on 12/29/2021
 */

class GalleryPresenterImpl constructor(
    private val instagramAPIService: InstagramAPIService,
    private val instagramGraphService: InstagramGraphService,
    private val galleryView: GalleryView
) :
    GalleryPresenter {

    override fun getImages() {
        instagramAPIService.getAccessToken(
            clientId = BuildConfig.INSTAGRAM_CLIENT_ID,
            clientSecret = BuildConfig.INSTAGRAM_SECRET_ID,
            code = LocalDataSource.getAuthenticationToken(),
            grantType = "authorization_code",
            redirectUri = BuildConfig.INSTAGRAM_REDIRECT_URI
        )
            .map(::saveAccessTokenAndUserId)
            .flatMap {
                instagramGraphService.getMedias(
                    LocalDataSource.getAccessToken(),
                    "id,caption,media_type,media_url"
                )
            }
            .doOnNext { println(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                saveImages(response)
            }

    }

    private fun saveAccessTokenAndUserId(response: Response<AccessTokenResponse>) {
        response.body()?.let { accessTokenResponse ->
            LocalDataSource.setAccessToken(accessTokenResponse.accessToken.orEmpty())
            LocalDataSource.setUserId(accessTokenResponse.userId.orEmpty())
        }
    }

    private fun saveImages(response: Response<MediaResponse>) {
        val images = response.body()?.data?.filter { item ->
            item.mediaType == "IMAGE"
        }?.map { item ->
            item.mediaUrl.orEmpty()
        }.orEmpty()

        galleryView.setImages(images)
    }
}
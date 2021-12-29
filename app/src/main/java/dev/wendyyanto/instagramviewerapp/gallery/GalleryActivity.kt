package dev.wendyyanto.instagramviewerapp.gallery

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.wendyyanto.instagramviewerapp.R
import dev.wendyyanto.instagramviewerapp.data.RemoteDataSource
import dev.wendyyanto.instagramviewerapp.gallery.presenter.GalleryPresenterImpl


/**
 * Created by wendy.yanto on 12/29/2021
 */

class GalleryActivity : AppCompatActivity(), GalleryView {

    private val galleryPresenter = GalleryPresenterImpl(
        RemoteDataSource.getInstagramAPIService(),
        RemoteDataSource.getInstagramGraphService(),
        this
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        galleryPresenter.getImages()
    }

    override fun setImages(images: List<String>) {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_gallery)

        with(recyclerView) {
            adapter = GalleryAdapter(images)
            layoutManager = GridLayoutManager(context, 3)
        }
    }
}
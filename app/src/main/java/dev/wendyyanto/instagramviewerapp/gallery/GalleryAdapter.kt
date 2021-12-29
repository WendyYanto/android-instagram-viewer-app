package dev.wendyyanto.instagramviewerapp.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.wendyyanto.instagramviewerapp.R


/**
 * Created by wendy.yanto on 12/29/2021
 */

class GalleryAdapter(private val items: List<String>) :
    RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class GalleryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(imageUrl: String) {
            Glide.with(view.context)
                .load(imageUrl)
                .into(view.findViewById(R.id.iv_gallery))
        }
    }

}
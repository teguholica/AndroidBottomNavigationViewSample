package com.teguholica.androidbottomnavigation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.store_item_row.view.*

/**
 * Created by teguholica on 10/01/18.
 * Store list adapter
 */
class StoreAdapter(private val movies: List<Movie>): RecyclerView.Adapter<StoreAdapter.ViewHolder>() {

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.load(movies[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.store_item_row, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun load(movie: Movie) {
            with(itemView) {
                vTitle.text = movie.title
                vPrice.text = movie.price

                Glide.with(itemView.context)
                        .load(movie.image)
                        .into(vThumbnail)
            }
        }
    }

}
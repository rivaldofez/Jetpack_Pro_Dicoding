package com.rivaldofez.moviers.ui.home.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rivaldofez.moviers.databinding.ItemGridBinding
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowItem

class TvShowAdapter(private val callback: TvShowFragmentCallback): RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private val listTvShows = ArrayList<TvShowItem>()

    fun setTvShows(tvShows: List<TvShowItem>?){
        if(tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemGridBinding = ItemGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemGridBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShows.size

    inner class TvShowViewHolder(private val binding: ItemGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowItem){
            with(binding){
                tvTitle.text = tvShow.name
                ratingMovie.rating = (0.5F * tvShow.voteAverage.toFloat())

                containerItem.setOnClickListener{callback.onTvShowClick(tvShow)}

                Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w500"+tvShow.posterPath)
                    .into(imgPoster)
            }
        }
    }
}
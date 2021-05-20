package com.rivaldofez.moviers.ui.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rivaldofez.moviers.databinding.ItemGridBinding
import com.rivaldofez.moviers.entity.TvShowEntity

class TvShowAdapter(private val callback: TvShowFragmentCallback): RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private val listTvShows = ArrayList<TvShowEntity>()

    fun setTvShows(tvShows: List<TvShowEntity>?){
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
        fun bind(tvShow: TvShowEntity){
            with(binding){
                tvTitle.text = tvShow.title
                ratingMovie.rating = tvShow.rating

                containerItem.setOnClickListener{callback.onTvShowClick(tvShow)}

                Glide.with(itemView.context).load(tvShow.posterPath)
                    .into(imgPoster)
            }
        }
    }
}
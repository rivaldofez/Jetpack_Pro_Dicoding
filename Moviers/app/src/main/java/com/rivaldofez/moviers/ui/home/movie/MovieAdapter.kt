package com.rivaldofez.moviers.ui.home.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rivaldofez.moviers.databinding.ItemGridBinding
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieItem

class MovieAdapter(private val callback: MovieFragmentCallback): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val listMovies = ArrayList<MovieItem>()

    fun setMovies(movies: List<MovieItem>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemGridBinding =  ItemGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemGridBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MovieViewHolder(private val binding: ItemGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieItem){
            with(binding){
                tvTitle.text = movie.title
                ratingMovie.rating = (0.5F * movie.voteAverage.toFloat())

                containerItem.setOnClickListener{callback.onMovieClick(movie)}

                Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w500"+movie.posterPath)
                    .into(imgPoster)
            }
        }
    }
}
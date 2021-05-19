package com.rivaldofez.moviers.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rivaldofez.moviers.databinding.ItemGridBinding
import com.rivaldofez.moviers.entity.MovieEntity

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
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

    class MovieViewHolder(private val binding: ItemGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity){
            with(binding){
                tvTitle.text = movie.title

                Glide.with(itemView.context).load(movie.posterPath)
                    .into(imgPoster)
            }
        }
    }
}
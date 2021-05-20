package com.rivaldofez.moviers.ui.detail.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rivaldofez.moviers.databinding.ActivityDetailMovieBinding
import com.rivaldofez.moviers.entity.MovieEntity
import com.rivaldofez.moviers.ui.detail.tvshow.DetailTvShowViewModel
import com.rivaldofez.moviers.utils.DataDummy

class DetailMovie : AppCompatActivity() {
    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailMovieBinding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(detailMovieBinding.root)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]

        val bundle = intent.extras
        if(bundle != null){
            val movieId = bundle.getInt(EXTRA_MOVIE)
            if(movieId != null){
                viewModel.setCurrentMovie(movieId)
                setContentView(viewModel.getMovie())
            }
        }
    }

    fun setContentView(movie: MovieEntity){
        Glide.with(this).load(movie.posterPath).into(detailMovieBinding.imgPoster)
        Glide.with(this).load(movie.backdropPath).into(detailMovieBinding.imgBackdrop)
        detailMovieBinding.tvDate.text = movie.date
        detailMovieBinding.tvTitle.text = movie.title
        detailMovieBinding.tvOverview.text = movie.overview
        detailMovieBinding.ratingMovie.rating = movie.rating
        detailMovieBinding.tvStudio.text = movie.studio
    }
}
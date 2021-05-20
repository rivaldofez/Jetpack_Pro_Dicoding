package com.rivaldofez.moviers.ui.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.rivaldofez.moviers.R
import com.rivaldofez.moviers.databinding.ActivityDetailMovieBinding
import com.rivaldofez.moviers.ui.tvshow.DetailTvShow
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

        val bundle = intent.extras
        if(bundle != null){
            val movieId = bundle.getInt(EXTRA_MOVIE)
            Log.d("Teston", movieId.toString())
            if(movieId != null){
                val allMovies = DataDummy.generateDummyMovies()
                for(movie in allMovies){
                    if(movie.id == movieId){
                        Glide.with(this).load(movie.posterPath).into(detailMovieBinding.imgPoster)
                        Glide.with(this).load(movie.backdropPath).into(detailMovieBinding.imgBackdrop)
                        detailMovieBinding.tvDate.text = movie.date
                        detailMovieBinding.tvTitle.text = movie.title
                        detailMovieBinding.tvOverview.text = movie.overview
                        detailMovieBinding.ratingMovie.rating = movie.rating
                        detailMovieBinding.tvStudio.text = movie.studio
                    }
                }
            }
        }
    }
}
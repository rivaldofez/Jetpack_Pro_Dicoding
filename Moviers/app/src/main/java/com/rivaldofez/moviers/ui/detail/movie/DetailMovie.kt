package com.rivaldofez.moviers.ui.detail.movie

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rivaldofez.moviers.R
import com.rivaldofez.moviers.databinding.ActivityDetailMovieBinding
import com.rivaldofez.moviers.data.source.local.entity.MovieEntity
import com.rivaldofez.moviers.ui.trailer.TrailerActivity

class DetailMovie : AppCompatActivity() {
    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }
    private lateinit var detailMovieBinding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(detailMovieBinding.root)
        setActionBar()

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]

        val bundle = intent.extras
        if(bundle != null){
            val movieId = bundle.getString(EXTRA_MOVIE)
            if(movieId != null){
                viewModel.setCurrentMovie(movieId)
                setContentView(viewModel.getMovie())
            }
        }
    }

    private fun setContentView(movie: MovieEntity){
        Glide.with(this).load(movie.posterPath).into(detailMovieBinding.imgPoster)
        Glide.with(this).load(movie.backdropPath).into(detailMovieBinding.imgBackdrop)
        detailMovieBinding.tvDate.text = movie.date
        detailMovieBinding.tvTitle.text = movie.title
        detailMovieBinding.tvOverview.text = movie.overview
        detailMovieBinding.ratingMovie.rating = movie.rating
        detailMovieBinding.tvStudio.text = movie.studio

        detailMovieBinding.btnTrailer.setOnClickListener {
            val intent = Intent(this, TrailerActivity::class.java)
            intent.putExtra(TrailerActivity.EXTRA_TRAILER, movie.trailerUrl)
            startActivity(intent)
        }
    }

    private fun setActionBar(){
        supportActionBar?.title = getString(R.string.detail_movie)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}
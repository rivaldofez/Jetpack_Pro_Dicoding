package com.rivaldofez.moviers.ui.detail.movie

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rivaldofez.moviers.R
import com.rivaldofez.moviers.databinding.ActivityDetailMovieBinding
import com.rivaldofez.moviers.data.source.remote.response.movie.MovieEntityResponse
import com.rivaldofez.moviers.ui.webview.WebViewActivity
import com.rivaldofez.moviers.utils.formatCurrency
import com.rivaldofez.moviers.utils.formatDate
import com.rivaldofez.moviers.utils.formatRuntime
import com.rivaldofez.moviers.utils.generateButtonTextView
import com.rivaldofez.moviers.viewmodel.ViewModelFactoryMovie

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

        val factory = ViewModelFactoryMovie.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val bundle = intent.extras
        if(bundle != null){
            val movieId = bundle.getString(EXTRA_MOVIE)
            if(movieId != null){
                viewModel.setCurrentMovie(movieId)
                viewModel.getDetailMovie().observe(this, { movie ->
                    setContentView(movie)
                })
            }
        }
    }

    private fun setContentView(movie: MovieEntityResponse){
        Glide.with(this).load("https://image.tmdb.org/t/p/w500"+movie.posterPath).into(detailMovieBinding.imgPoster)
        Glide.with(this).load("https://image.tmdb.org/t/p/w500"+movie.backdropPath).into(detailMovieBinding.imgBackdrop)
        detailMovieBinding.tvDate.text = formatDate(movie.releaseDate)
        detailMovieBinding.tvTitle.text = movie.title
        detailMovieBinding.tvSynopsis.text = movie.overview
        detailMovieBinding.tvOriginal.text = movie.originalTitle
        detailMovieBinding.tvHomepage.text = movie.homepage
        detailMovieBinding.tvStatus.text = movie.status
        detailMovieBinding.tvDuration.text = formatRuntime(movie.runtime)
        detailMovieBinding.chartPopularity.setProgress(movie.voteAverage * 10F, true)
        detailMovieBinding.tvBudget.text = formatCurrency(movie.budget)
        detailMovieBinding.tvRevenue.text = formatCurrency(movie.revenue)
        detailMovieBinding.btnTrailer.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra(WebViewActivity.EXTRA_LINKS, movie.homepage)
            startActivity(intent)
        }

        for(genre in movie.genres){
            this.generateButtonTextView(genre.name, detailMovieBinding.llGenre)
        }

        for (language in movie.spokenLanguages){
            this.generateButtonTextView(language.englishName, detailMovieBinding.llLanguage)
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
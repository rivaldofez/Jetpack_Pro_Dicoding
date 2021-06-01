package com.rivaldofez.moviers.ui.detail.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rivaldofez.moviers.BuildConfig
import com.rivaldofez.moviers.R
import com.rivaldofez.moviers.databinding.ActivityDetailTvShowBinding
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowEntityResponse
import com.rivaldofez.moviers.ui.webview.WebViewActivity
import com.rivaldofez.moviers.utils.DataDummy
import com.rivaldofez.moviers.utils.formatDate
import com.rivaldofez.moviers.utils.generateButtonTextView
import com.rivaldofez.moviers.viewmodel.ViewModelFactoryTvShow

class DetailTvShow : AppCompatActivity() {
    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private lateinit var detailTvShowBinding: ActivityDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(detailTvShowBinding.root)
        setActionBar()

        val factory = ViewModelFactoryTvShow.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

        val bundle = intent.extras
        if(bundle != null){
            val tvShowId = bundle.getString(EXTRA_TVSHOW)
            if(tvShowId != null){
                viewModel.setCurrentTvShow(tvShowId)
                viewModel.getDetailTvShow().observe(this, {tvshow->
                    setViewContent(tvshow)
                })
                viewModel.getLoadingStatus().observe(this, {status ->
                    if(status){
                        detailTvShowBinding.progressBar.visibility = View.VISIBLE
                    }else{
                        detailTvShowBinding.progressBar.visibility = View.GONE
                    }
                })
            }
        }
    }

    private fun setViewContent(tvShow: TvShowEntityResponse){
        Glide.with(this).load(BuildConfig.API_PATH_IMAGE + tvShow.posterPath).into(detailTvShowBinding.imgPoster)
        Glide.with(this).load(BuildConfig.API_PATH_IMAGE + tvShow.backdropPath).into(detailTvShowBinding.imgBackdrop)
        detailTvShowBinding.tvDate.text = formatDate(tvShow.firstAirDate)
        detailTvShowBinding.tvTitle.text = tvShow.name
        detailTvShowBinding.tvSynopsis.text = tvShow.overview
        detailTvShowBinding.tvOriginal.text = tvShow.originalName
        detailTvShowBinding.tvHomepage.text = tvShow.homepage
        detailTvShowBinding.tvStatus.text = tvShow.status
        detailTvShowBinding.tvEpisode.text = tvShow.numberOfEpisodes.toString()
        detailTvShowBinding.tvSeason.text = tvShow.numberOfSeasons.toString()
        detailTvShowBinding.tvLatestEpisode.text = getString(R.string.episode_run, tvShow.episodeRunTime.toString())
        detailTvShowBinding.chartPopularity.setProgress(tvShow.voteAverage * 10F, true)

        detailTvShowBinding.btnHomePage.setOnClickListener{
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra(WebViewActivity.EXTRA_LINKS, tvShow.homepage)
            startActivity(intent)
        }

        for(genre in tvShow.genres){
            this.generateButtonTextView(genre.name, detailTvShowBinding.llGenre)
        }

        for (language in tvShow.spokenLanguages){
            this.generateButtonTextView(language.englishName, detailTvShowBinding.llLanguage)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }

    private fun setActionBar(){
        supportActionBar?.title = getString(R.string.detail_tvshow)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
package com.rivaldofez.moviers.ui.detail.tvshow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rivaldofez.moviers.databinding.ActivityDetailTvShowBinding
import com.rivaldofez.moviers.entity.TvShowEntity
import com.rivaldofez.moviers.ui.trailer.TrailerActivity

class DetailTvShow : AppCompatActivity() {
    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private lateinit var detailTvShowBinding: ActivityDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(detailTvShowBinding.root)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailTvShowViewModel::class.java]

        val bundle = intent.extras
        if(bundle != null){
            val tvShowId = bundle.getString(EXTRA_TVSHOW)
            if(tvShowId != null){
                viewModel.setCurrentTvShow(tvShowId)
                setViewContent(viewModel.getTvShow())
            }
        }
    }

    private fun setViewContent(tvShow: TvShowEntity){
        Glide.with(this).load(tvShow.posterPath).into(detailTvShowBinding.imgPoster)
        Glide.with(this).load(tvShow.backdropPath).into(detailTvShowBinding.imgBackdrop)
        detailTvShowBinding.tvDate.text = tvShow.date
        detailTvShowBinding.tvTitle.text = tvShow.title
        detailTvShowBinding.tvOverview.text = tvShow.overview
        detailTvShowBinding.ratingTv.rating = tvShow.rating
        detailTvShowBinding.tvStatus.text = tvShow.status
        detailTvShowBinding.tvStudio.text = tvShow.studio
        detailTvShowBinding.tvEpisode.text = "${tvShow.episode}\nEPS"

        detailTvShowBinding.btnTrailer.setOnClickListener{
            val intent = Intent(this, TrailerActivity::class.java)
            intent.putExtra(TrailerActivity.EXTRA_TRAILER, tvShow.trailerUrl)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}
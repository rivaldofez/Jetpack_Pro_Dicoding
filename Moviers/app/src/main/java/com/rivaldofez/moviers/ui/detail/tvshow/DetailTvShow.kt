package com.rivaldofez.moviers.ui.detail.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rivaldofez.moviers.databinding.ActivityDetailTvShowBinding
import com.rivaldofez.moviers.entity.TvShowEntity

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
            val tvShowId = bundle.getInt(EXTRA_TVSHOW)
            if(tvShowId != null){
                viewModel.setCurrentTvShow(tvShowId)
                setViewContent(viewModel.getTvShow())
            }
        }
    }

    fun setViewContent(tvShow: TvShowEntity){
        Glide.with(this).load(tvShow.posterPath).into(detailTvShowBinding.imgPoster)
        Glide.with(this).load(tvShow.backdropPath).into(detailTvShowBinding.imgBackdrop)
        detailTvShowBinding.tvDate.text = tvShow.date
        detailTvShowBinding.tvTitle.text = tvShow.title
        detailTvShowBinding.tvOverview.text = tvShow.overview
        detailTvShowBinding.ratingTv.rating = tvShow.rating
        detailTvShowBinding.tvStatus.text = tvShow.status
        detailTvShowBinding.tvStudio.text = tvShow.studio
        detailTvShowBinding.tvEpisode.text = "${tvShow.episode}\nEPS"
    }
}
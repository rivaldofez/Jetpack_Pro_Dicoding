package com.rivaldofez.moviers.ui.home.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rivaldofez.moviers.databinding.FragmentTvShowBinding
import com.rivaldofez.moviers.data.source.remote.response.tvshow.TvShowItem
import com.rivaldofez.moviers.ui.detail.tvshow.DetailTvShow
import com.rivaldofez.moviers.viewmodel.ViewModelFactoryTvShow

class TvShowFragment : Fragment(), TvShowFragmentCallback {
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val factory = ViewModelFactoryTvShow.getInstance()
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter(this)
            viewModel.getPopularTvShows().observe(viewLifecycleOwner, {tvShows->
                tvShowAdapter.setTvShows(tvShows)
            })

            with(fragmentTvShowBinding.rvTvshow){
                layoutManager = GridLayoutManager(context, 3)
                adapter = tvShowAdapter
            }
        }
    }

    override fun onTvShowClick(tvShow: TvShowItem) {
        val intent = Intent(context, DetailTvShow::class.java)
        intent.putExtra(DetailTvShow.EXTRA_TVSHOW, tvShow.id.toString())
        requireContext().startActivity(intent)
    }
}
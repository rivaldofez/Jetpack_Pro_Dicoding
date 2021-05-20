package com.rivaldofez.moviers.ui.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.rivaldofez.moviers.databinding.FragmentTvShowBinding
import com.rivaldofez.moviers.entity.TvShowEntity
import com.rivaldofez.moviers.utils.DataDummy

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

        val listTvShow = DataDummy.generateDummyTvShow()
        val gridLayoutManager = GridLayoutManager(context, 3)
        val adapter = TvShowAdapter(this)
        adapter.setTvShows(listTvShow)

        fragmentTvShowBinding.rvTvshow.layoutManager = gridLayoutManager
        fragmentTvShowBinding.rvTvshow.adapter = adapter
    }

    override fun onTvShowClick(tvShow: TvShowEntity) {
        Toast.makeText(context,"Click item ${tvShow.title}", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, DetailTvShow::class.java)
        intent.putExtra(DetailTvShow.EXTRA_TVSHOW, tvShow.id)
        requireContext().startActivity(intent)
    }

}
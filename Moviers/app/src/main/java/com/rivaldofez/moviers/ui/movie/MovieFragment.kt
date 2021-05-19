package com.rivaldofez.moviers.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.rivaldofez.moviers.R
import com.rivaldofez.moviers.databinding.FragmentMovieBinding
import com.rivaldofez.moviers.utils.DataDummy

class MovieFragment : Fragment() {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater,container,false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listMovies = DataDummy.generateDummyMovies()
        val gridLayoutManager =  GridLayoutManager(context, 3)
        val adapter = MovieAdapter()
        adapter.setMovies(listMovies)

        fragmentMovieBinding.rvMovies.layoutManager = gridLayoutManager
        fragmentMovieBinding.rvMovies.adapter = adapter

    }
}
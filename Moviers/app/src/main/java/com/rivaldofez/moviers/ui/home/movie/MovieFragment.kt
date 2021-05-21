package com.rivaldofez.moviers.ui.home.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rivaldofez.moviers.databinding.FragmentMovieBinding
import com.rivaldofez.moviers.entity.MovieEntity
import com.rivaldofez.moviers.ui.detail.movie.DetailMovie

class MovieFragment : Fragment(), MovieFragmentCallback {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater,container,false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
            val movies = viewModel.getMovies()

            val movieAdapter = MovieAdapter(this)
            movieAdapter.setMovies(movies)

            with(fragmentMovieBinding.rvMovies){
                layoutManager = GridLayoutManager(context, 3)
                adapter = movieAdapter
            }
        }
    }

    override fun onMovieClick(movie: MovieEntity) {
        val intent = Intent(context, DetailMovie::class.java)
        intent.putExtra(DetailMovie.EXTRA_MOVIE, movie.id)
        requireContext().startActivity(intent)
    }
}
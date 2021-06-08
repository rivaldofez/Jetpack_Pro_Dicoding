package com.rivaldofez.moviers.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.rivaldofez.moviers.R
import com.rivaldofez.moviers.databinding.ActivityHomeBinding
import com.rivaldofez.moviers.ui.home.movie.MovieFragmentDirections
import com.rivaldofez.moviers.ui.home.tvshow.TvShowFragmentDirections

class HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        homeBinding.bnavMain.setNavigationChangeListener{ _, position ->
            when(position){
                0 -> {
                    val movieFragment = TvShowFragmentDirections.actionTvShowFragmentToMovieFragment()
                    findNavController(R.id.nav_host_fragment).navigate(movieFragment)
                }
                1 -> {
                    val tvShowFragment = MovieFragmentDirections.actionMovieFragmentToTvShowFragment()
                    findNavController(R.id.nav_host_fragment).navigate(tvShowFragment)
                }
            }
        }
    }
}